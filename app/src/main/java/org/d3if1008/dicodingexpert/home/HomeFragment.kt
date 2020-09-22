package org.d3if1008.dicodingexpert.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_error.*
import org.d3if1008.core.di.data.Resource
import org.d3if1008.core.ui.FootballAdapter
import org.d3if1008.dicodingexpert.MyApplication
import org.d3if1008.dicodingexpert.R
import org.d3if1008.dicodingexpert.detail.DetailFootballActivity
import org.d3if1008.dicodingexpert.di.ViewModelFactory
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val homeViewModel: HomeViewModel by viewModels {
        factory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val footballdapter = FootballAdapter()
            footballdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailFootballActivity::class.java)
                intent.putExtra(DetailFootballActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.football.observe(viewLifecycleOwner, Observer { football ->
                if (football != null) {
                    when (football) {
                        is Resource.Loading -> progress_bar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            progress_bar.visibility = View.GONE
                            footballdapter.setData(football.data)
                        }
                        is Resource.Error -> {
                            progress_bar.visibility = View.GONE
                            error_view.visibility = View.VISIBLE
                            tv_error.text = football.message ?: getString(R.string.error)
                        }
                    }
                }
            })

            with(tourism) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = footballdapter
            }
        }
    }
}
