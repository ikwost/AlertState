package com.ikwost.alertstate.domain.repository

import com.ikwost.alertstate.domain.model.ApiRequest
import com.ikwost.alertstate.domain.model.ApiResponse
import com.ikwost.alertstate.domain.model.UserLocation
import com.ikwost.alertstate.domain.model.UserUpdate
import com.ikwost.alertstate.util.RequestState
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun saveSignedInState(signedIn: Boolean)
    fun readSignedInState(): Flow<Boolean>
    suspend fun verifyTokenOnBackend(request: ApiRequest): ApiResponse
    suspend fun getUserInfo(): ApiResponse
    suspend fun updateUser(userUpdate: UserUpdate): ApiResponse
    suspend fun deleteUser(): ApiResponse
    suspend fun clearSession(): ApiResponse
    suspend fun getAllLocations(): ApiResponse
    suspend fun initSocketSession(username: String): ApiResponse
    suspend fun sendLocation(userLocation: UserLocation): ApiResponse
    fun observeLocations(): Flow<UserLocation>
    suspend fun closeSocketSession(): ApiResponse

}