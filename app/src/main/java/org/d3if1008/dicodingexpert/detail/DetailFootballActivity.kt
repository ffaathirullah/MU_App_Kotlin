package org.d3if1008.dicodingexpert

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_football.*
import kotlinx.android.synthetic.main.content_detail_football.*
import org.d3if1008.dicodingexpert.domain.model.Football

class DetailFootballActivity : AppCompatActivity() {

    private lateinit var detaillFootballViewModel: DetailFootballViewModel

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_football)
        setSupportActionBar(toolbar)

        val factory = ViewModelFactory.getInstance(this)
        detaillFootballViewModel = ViewModelProvider(this, factory)[DetailFootballViewModel::class.java]

        val detailFootball = intent.getParcelableExtra<Football>(EXTRA_DATA)
        showDetailTourism(detailFootball)
    }

    private fun showDetailTourism(detailFootball: Football?) {
        detailFootball?.let {
            supportActionBar?.title = detailFootball.name
            tv_detail_description.text = detailFootball.description
            Glide.with(this@DetailFootballActivity)
                .load(detailFootball.image)
                .into(text_detail_image)

            var statusFavorite = detailFootball.isFavorite
            setStatusFavorite(statusFavorite)
            fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detaillFootballViewModel.setFavoriteFootball(detailFootball, statusFavorite)
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
