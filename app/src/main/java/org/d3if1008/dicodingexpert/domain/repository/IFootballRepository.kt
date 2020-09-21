package org.d3if1008.dicodingexpert.domain.repository

import kotlinx.coroutines.flow.Flow
import org.d3if1008.dicodingexpert.domain.model.Football

interface IFootballRepository {

    fun getAllFootball(): Flow<org.d3if1008.dicodingexpert.Resource<List<Football>>>

    fun getFavoriteFootball(): Flow<List<Football>>

    fun setFavoriteFootball(tourism: Football, state: Boolean)

}