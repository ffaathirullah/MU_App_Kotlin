package org.d3if1008.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_favorite.*
import org.d3if1008.core.ui.FootballAdapter
import org.d3if1008.dicodingexpert.detail.DetailFootballActivity
import org.d3if1008.favorite.di.favoriteModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FootballFavorite : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        loadKoinModules(favoriteModule)

        supportActionBar?.title = "Favorite"

        val sportAdapter = FootballAdapter()
        sportAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailFootballActivity::class.java)
            intent.putExtra(DetailFootballActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteFootball.observe(this, Observer {
            sportAdapter.setData(it)
            view_empty.visibility = if (it.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(football) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = sportAdapter
        }
    }

}
