package com.ikwost.alertstate.data.remote

import com.ikwost.alertstate.domain.model.UserLocation
import com.ikwost.alertstate.util.RequestState
import kotlinx.coroutines.flow.Flow

interface MapSocketService {

    suspend fun initSocketSession(username: String): RequestState<Unit>

    suspend fun sendLocation(userLocation: UserLocation)

    fun observeLocations(): Flow<UserLocation>

    suspend fun closeSocketSession()

}