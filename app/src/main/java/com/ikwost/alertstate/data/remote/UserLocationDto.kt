package com.ikwost.alertstate.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class UserLocationDto(
    val lat: Long,
    val lng: Long,
    val userId: String
)