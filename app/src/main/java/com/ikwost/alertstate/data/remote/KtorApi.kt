package com.ikwost.alertstate.data.remote

import com.ikwost.alertstate.domain.model.ApiRequest
import com.ikwost.alertstate.domain.model.ApiResponse
import com.ikwost.alertstate.domain.model.UserLocation
import com.ikwost.alertstate.domain.model.UserUpdate
import retrofit2.http.*

interface KtorApi {

    @POST("/token_verification")
    suspend fun verifyTokenOnBackend(
        @Body request: ApiRequest
    ): ApiResponse

    @GET("/get_user")
    suspend fun getUserInfo(): ApiResponse

    @PUT("/update_user")
    suspend fun updateUser(
        @Body userUpdate: UserUpdate
    ): ApiResponse

    @DELETE("/delete_user")
    suspend fun deleteUser(): ApiResponse

    @GET("/sign_out")
    suspend fun clearSession(): ApiResponse

    @GET("/locations")
    suspend fun getAllLocations(): UserLocation




}