package org.d3if1008.dicodingexpert.domain.usecase

import org.d3if1008.dicodingexpert.domain.model.Football
import org.d3if1008.dicodingexpert.domain.repository.IFootballRepository

class FootballInteractor(private val footballRepository: IFootballRepository): FootballUseCase {

    override fun getAllFootball() = footballRepository.getAllFootball()

    override fun getFavoriteFootball() = footballRepository.getFavoriteFootball()

    override fun setFavoriteFootball(tourism: Football, state: Boolean) = footballRepository.setFavoriteFootball(tourism, state)
}