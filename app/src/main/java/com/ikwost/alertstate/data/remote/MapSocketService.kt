package com.ikwost.alertstate.data.remote

import com.ikwost.alertstate.domain.model.ApiResponse
import com.ikwost.alertstate.domain.model.UserLocation
import com.ikwost.alertstate.util.Constants.BASE_URL
import com.ikwost.alertstate.util.RequestState
import kotlinx.coroutines.flow.Flow

interface MapSocketService {

    suspend fun initSocketSession(username: String): ApiResponse

    suspend fun sendLocation(userLocation: UserLocation): ApiResponse

    fun observeLocations(): Flow<UserLocation>

    suspend fun closeSocketSession():ApiResponse

    sealed class Endpoints(val url: String) {
        object MapSocket : Endpoints("$BASE_URL/map-socket")
    }

}