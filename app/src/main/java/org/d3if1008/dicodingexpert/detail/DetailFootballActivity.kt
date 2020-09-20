package org.d3if1008.dicodingexpert

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_football.*
import kotlinx.android.synthetic.main.content_detail_football.*

class DetailFootballActivity : AppCompatActivity() {

    private lateinit var detaillFootballViewModel: DetaillFootballViewModel

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_football)
        setSupportActionBar(toolbar)

        val factory = ViewModelFactory.getInstance(this)
        detaillFootballViewModel = ViewModelProvider(this, factory)[DetaillFootballViewModel::class.java]

        val detailTourism = intent.getParcelableExtra<FootballEntity>(EXTRA_DATA)
        showDetailTourism(detailTourism)
    }

    private fun showDetailTourism(detailTourism: FootballEntity?) {
        detailTourism?.let {
            supportActionBar?.title = detailTourism.name
            tv_detail_description.text = detailTourism.description
            Glide.with(this@DetailFootballActivity)
                .load(detailTourism.image)
                .into(text_detail_image)

            var statusFavorite = detailTourism.isFavorite
            setStatusFavorite(statusFavorite)
            fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detaillFootballViewModel.setFavoriteTourism(detailTourism, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_putih))
        } else {
            fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_bukan_favorite_white))
        }
    }
}
