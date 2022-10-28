package com.ikwost.alertstate.data.repository

import com.ikwost.alertstate.data.remote.KtorApiRetrofit
import com.ikwost.alertstate.data.remote.MapSocketService
import com.ikwost.alertstate.domain.model.ApiRequest
import com.ikwost.alertstate.domain.model.ApiResponse
import com.ikwost.alertstate.domain.model.UserLocation
import com.ikwost.alertstate.domain.model.UserUpdate
import com.ikwost.alertstate.domain.repository.DataStoreOperations
import com.ikwost.alertstate.domain.repository.Repository
import com.ikwost.alertstate.util.RequestState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dataStoreOperations: DataStoreOperations,
    private val ktorApiRetrofit: KtorApiRetrofit,
    private val mapSocketService: MapSocketService
) : Repository {
    override suspend fun saveSignedInState(signedIn: Boolean) {
        dataStoreOperations.saveSignedInState(signedIn = signedIn)
    }

    override fun readSignedInState(): Flow<Boolean> {
        return dataStoreOperations.readSignedInState()
    }

    override suspend fun verifyTokenOnBackend(request: ApiRequest): ApiResponse {
        return try {
            ktorApiRetrofit.verifyTokenOnBackend(request = request)
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun getUserInfo(): ApiResponse {
        return try {
            ktorApiRetrofit.getUserInfo()
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun updateUser(userUpdate: UserUpdate): ApiResponse {
        return try {
            ktorApiRetrofit.updateUser(userUpdate = userUpdate)
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun deleteUser(): ApiResponse {
        return try {
            ktorApiRetrofit.deleteUser()
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun clearSession(): ApiResponse {
        return try {
            ktorApiRetrofit.clearSession()
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun getAllLocations(): ApiResponse {
        return try {
            ktorApiRetrofit.getAllLocations()
        } catch (e: Exception) {
            ApiResponse(success = false, error = e, locations = emptyList())
        }
    }

    override suspend fun initSocketSession(username: String): ApiResponse {
        return try {
            mapSocketService.initSocketSession(username)
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun sendLocation(userLocation: UserLocation): ApiResponse {
        return try {
            mapSocketService.sendLocation(userLocation)
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override fun observeLocations(): Flow<UserLocation> {
        return try {
            mapSocketService.observeLocations()
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
            emptyFlow()
        }
    }

    override suspend fun closeSocketSession(): ApiResponse {
        return try {
            mapSocketService.closeSocketSession()

        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }
}