package com.ikwost.alertstate.data.repository

import com.google.android.gms.common.api.Api
import com.ikwost.alertstate.data.remote.MapSocketService
import com.ikwost.alertstate.domain.model.ApiResponse
import com.ikwost.alertstate.domain.model.UserLocation
import com.ikwost.alertstate.util.RequestState
import io.ktor.client.*
import io.ktor.client.plugins.websocket.*
import io.ktor.client.request.*
import io.ktor.websocket.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.isActive

class MapSocketServiceImpl(private val client: HttpClient) : MapSocketService {

    private var socket: DefaultClientWebSocketSession? = null

    override suspend fun initSocketSession(username: String): ApiResponse {
        return try {
            client.webSocket(urlString = MapSocketService.Endpoints.MapSocket.url) {
                socket = this
            }

            if (socket?.isActive == true) {
                ApiResponse(success = true)
            } else {
                ApiResponse(success = false)
            }

        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun sendLocation(userLocation: UserLocation): ApiResponse {
        return try {
            socket?.sendSerialized(userLocation)
            ApiResponse(success = true)
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override fun observeLocations(): Flow<UserLocation> {
        TODO("Not yet implemented")
    }

    override suspend fun closeSocketSession(): ApiResponse {
        TODO("Not yet implemented")
    }
}