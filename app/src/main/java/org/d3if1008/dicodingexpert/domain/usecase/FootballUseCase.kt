package org.d3if1008.dicodingexpert.domain.usecase

import kotlinx.coroutines.flow.Flow
import org.d3if1008.dicodingexpert.Resource
import org.d3if1008.dicodingexpert.domain.model.Football


interface FootballUseCase {
    fun getAllFootball(): Flow<Resource<List<Football>>>
    fun getFavoriteFootball(): Flow<List<Football>>
    fun setFavoriteFootball(tourism: Football, state: Boolean)
}