package org.d3if1008.core.domain.usecase

import kotlinx.coroutines.flow.Flow
import org.d3if1008.core.data.Resource
import org.d3if1008.core.domain.model.Football


interface FootballUseCase {
    fun getAllFootball(): Flow<Resource<List<Football>>>
    fun getFavoriteFootball(): Flow<List<Football>>
    fun setFavoriteFootball(football: Football, state: Boolean)
}