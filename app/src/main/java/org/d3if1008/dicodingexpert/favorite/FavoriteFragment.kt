package org.d3if1008.dicodingexpert.favorite

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
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.d3if1008.dicodingexpert.MyApplication
import org.d3if1008.dicodingexpert.R
import org.d3if1008.dicodingexpert.core.ui.FootballAdapter
import org.d3if1008.dicodingexpert.core.ui.ViewModelFactory
import org.d3if1008.dicodingexpert.detail.DetailFootballActivity
import javax.inject.Inject

class FavoriteFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels {
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
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val footballAdapter = FootballAdapter()
            footballAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailFootballActivity::class.java)
                intent.putExtra(DetailFootballActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }


            favoriteViewModel.favoriteFootball.observe(viewLifecycleOwner, Observer { dataFootball ->
                footballAdapter.setData(dataFootball)
                view_empty.visibility = if (dataFootball.isNotEmpty()) View.GONE else View.VISIBLE
            })

            with(tourism) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = footballAdapter
            }
        }
    }
}
