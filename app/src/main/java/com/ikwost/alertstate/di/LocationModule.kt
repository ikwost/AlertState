package com.ikwost.alertstate.di

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.ikwost.alertstate.presentation.screen.map.location.DefaultLocationClient
import com.ikwost.alertstate.presentation.screen.map.location.LocationClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocationModule {
    @Provides
    @Singleton
    fun provideFusedLocationClient(@ApplicationContext appContext: Context): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(appContext)
    }

    @Provides
    @Singleton
    fun bindLocationClient(
        @ApplicationContext appContext: Context,
        client: FusedLocationProviderClient
    ): LocationClient {
        return DefaultLocationClient(appContext, client)
    }
}