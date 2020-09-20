package org.d3if1008.dicodingexpert.domain.repository

import androidx.lifecycle.LiveData
import com.bumptech.glide.load.engine.Resource
import org.d3if1008.dicodingexpert.domain.model.Football

interface IFootballRepository {

    fun getAllFootball(): LiveData<org.d3if1008.dicodingexpert.Resource<List<Football>>>

    fun getFavoriteFootball(): LiveData<List<Football>>

    fun setFavoriteFootball(tourism: Football, state: Boolean)

}