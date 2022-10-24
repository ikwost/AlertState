package com.ikwost.alertstate.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.ikwost.alertstate.data.remote.KtorApiRetrofit
import com.ikwost.alertstate.data.repository.DataStoreOperationsImpl
import com.ikwost.alertstate.data.repository.RepositoryImpl
import com.ikwost.alertstate.domain.repository.DataStoreOperations
import com.ikwost.alertstate.domain.repository.Repository
import com.ikwost.alertstate.util.Constants.PREFERENCES_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStorePreferences(
        @ApplicationContext context: Context
    ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = { context.preferencesDataStoreFile(PREFERENCES_NAME) }
        )
    }

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        dataStore: DataStore<Preferences>
    ): DataStoreOperations {
        return DataStoreOperationsImpl(dataStore = dataStore)
    }

    @Provides
    @Singleton
    fun provideRepository(
        dataStoreOperations: DataStoreOperations,
        ktorApiRetrofit: KtorApiRetrofit
    ): Repository {
        return RepositoryImpl(
            dataStoreOperations = dataStoreOperations,
            ktorApiRetrofit = ktorApiRetrofit
        )
    }

}