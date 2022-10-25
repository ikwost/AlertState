package com.ikwost.alertstate.di

import com.ikwost.alertstate.data.remote.MapSocketService
import com.ikwost.alertstate.data.repository.MapSocketServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.json.*
import io.ktor.client.plugins.kotlinx.serializer.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.websocket.*
import io.ktor.serialization.kotlinx.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModuleWebSocket {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(CIO) {
            install(Logging)
            install(WebSockets) {
                contentConverter = KotlinxWebsocketSerializationConverter(Json)
            }
            install(JsonPlugin) {
                serializer = KotlinxSerializer()
            }
        }
    }


    @Provides
    @Singleton
    fun provideChatSocketService(client: HttpClient): MapSocketService {
        return MapSocketServiceImpl(client)
    }
}