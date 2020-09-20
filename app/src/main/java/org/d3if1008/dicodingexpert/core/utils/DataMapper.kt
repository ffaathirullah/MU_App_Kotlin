package org.d3if1008.dicodingexpert

import com.dicoding.tourismapp.core.data.source.remote.response.FootballResponse
import org.d3if1008.dicodingexpert.domain.model.Football

object DataMapper {
    fun mapResponsesToEntities(input: List<FootballResponse>): List<FootballEntity> {
        val tourismList = ArrayList<FootballEntity>()
        input.map {
            val tourism = FootballEntity(
                tourismId = it.id,
                description = it.description,
                name = it.name,
                address = it.address,
                latitude = it.latitude,
                longitude = it.longitude,
                like = it.like,
                image = it.image,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }
    fun mapEntitiesToDomain(input: List<FootballEntity>): List<Football> =
        input.map {
            Football(
                footballId  = it.tourismId,
                description = it.description,
                name = it.name,
                address = it.address,
                latitude = it.latitude,
                longitude = it.longitude,
                like = it.like,
                image = it.image,
                isFavorite = it.isFavorite
            )
        }
    fun mapDomainToEntity(input: Football) = FootballEntity(
        tourismId = input.footballId,
        description = input.description,
        name = input.name,
        address = input.address,
        latitude = input.latitude,
        longitude = input.longitude,
        like = input.like,
        image = input.image,
        isFavorite = input.isFavorite
    )
}