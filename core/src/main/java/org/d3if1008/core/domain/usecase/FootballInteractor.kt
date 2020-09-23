package org.d3if1008.core.domain.usecase


import org.d3if1008.core.domain.model.Football
import org.d3if1008.core.domain.repository.IFootballRepository

class FootballInteractor(private val footballRepository: IFootballRepository): FootballUseCase {

    override fun getAllFootball() = footballRepository.getAllFootball()

    override fun getFavoriteFootball() = footballRepository.getFavoriteFootball()

    override fun setFavoriteFootball(football: Football, state: Boolean) = footballRepository.setFavoriteFootball(football, state)
}