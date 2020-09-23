package org.d3if1008.core.utils
import org.d3if1008.core.data.source.local.entity.FootballEntity
import org.d3if1008.core.data.source.remote.response.FootballResponse
import org.d3if1008.core.domain.model.Football

object DataMapper {
    fun mapResponsesToEntities(input: List<FootballResponse>): List<FootballEntity> {
        val footballList = ArrayList<FootballEntity>()
        input.map {
            val football = FootballEntity(
                footballId = it.id,
                description = it.description,
                name = it.name,
                address = it.address,
                latitude = it.latitude,
                longitude = it.longitude,
                like = it.like,
                image = it.image,
                isFavorite = false
            )
            footballList.add(football)
        }
        return footballList
    }
    fun mapEntitiesToDomain(input: List<FootballEntity>): List<Football> =
        input.map {
            Football(
                footballId = it.footballId,
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
        footballId  = input.footballId,
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