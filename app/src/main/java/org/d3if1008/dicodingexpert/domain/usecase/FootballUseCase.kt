package org.d3if1008.dicodingexpert.domain.usecase

import androidx.lifecycle.LiveData
import org.d3if1008.dicodingexpert.Resource
import org.d3if1008.dicodingexpert.domain.model.Football


interface FootballUseCase {
    fun getAllFootball(): LiveData<Resource<List<Football>>>
    fun getFavoriteFootball(): LiveData<List<Football>>
    fun setFavoriteFootball(tourism: Football, state: Boolean)
}