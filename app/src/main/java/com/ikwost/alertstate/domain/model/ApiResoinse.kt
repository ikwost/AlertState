package com.ikwost.alertstate.domain.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class ApiResponse(
    val success: Boolean,
    val user: User? = null,
    val message: String? = null,
    val locations: List<UserLocation>? = null,
    @Transient
    val error: Exception? = null
)
//add val data
