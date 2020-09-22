package org.d3if1008.dicodingexpert.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_football.*
import kotlinx.android.synthetic.main.content_detail_football.*
import org.d3if1008.core.domain.model.Football
import org.d3if1008.dicodingexpert.MyApplication
import org.d3if1008.dicodingexpert.R
import org.d3if1008.dicodingexpert.di.ViewModelFactory
import javax.inject.Inject

class DetailFootballActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val detaillFootballViewModel: DetailFootballViewModel by viewModels {
        factory
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_football)
        setSupportActionBar(tollbar)


        val detailFootball = intent.getParcelableExtra<Football>(EXTRA_DATA)
        showDetailFootball(detailFootball)
    }

    private fun showDetailFootball(detailFootball: Football?) {
        detailFootball?.let {
            supportActionBar?.title = detailFootball.name
            detail_description.text = detailFootball.description
            Glide.with(this@DetailFootballActivity)
                .load(detailFootball.image)
                .into(background)

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
