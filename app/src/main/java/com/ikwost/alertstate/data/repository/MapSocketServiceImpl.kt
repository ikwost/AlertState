package com.ikwost.alertstate.data.repository

import com.ikwost.alertstate.data.remote.MapSocketService
import com.ikwost.alertstate.domain.model.UserLocation
import com.ikwost.alertstate.util.RequestState
import kotlinx.coroutines.flow.Flow

class MapSocketServiceImpl : MapSocketService {
    override suspend fun initSocketSession(username: String): RequestState<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun sendLocation(userLocation: UserLocation) {
        TODO("Not yet implemented")
    }

    override fun observeLocations(): Flow<UserLocation> {
        TODO("Not yet implemented")
    }

    override suspend fun closeSocketSession() {
        TODO("Not yet implemented")
    }
}