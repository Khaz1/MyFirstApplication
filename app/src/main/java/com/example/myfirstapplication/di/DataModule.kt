package com.example.myfirstapplication.di

import android.app.Application
import com.example.myfirstapplication.data.database.AppDatabase
import com.example.myfirstapplication.data.database.CoinInfoDao
import com.example.myfirstapplication.data.network.ApiFactory
import com.example.myfirstapplication.data.network.ApiService
import com.example.myfirstapplication.data.repository.CoinRepositoryImpl
import com.example.myfirstapplication.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}
