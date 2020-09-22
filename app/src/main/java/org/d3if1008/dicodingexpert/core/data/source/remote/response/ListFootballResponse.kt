package org.d3if1008.dicodingexpert.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListFootballResponse(

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("places")
    val places: List<FootballResponse>,
)