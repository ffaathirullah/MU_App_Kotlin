package org.d3if1008.dicodingexpert

import com.dicoding.tourismapp.core.data.source.remote.response.FootballResponse

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
}