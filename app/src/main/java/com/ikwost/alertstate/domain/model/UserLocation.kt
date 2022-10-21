package com.ikwost.alertstate.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserLocation(
    val lat: Long,
    val lng: Long,
    val userId: String
) {
    fun toUserLocation(): UserLocation {
        return UserLocation(
            lat = lat,
            lng = lng,
            userId = userId
        )
    }
}
