package com.ilnytskyi.spendbase.di

import com.ilnytskyi.spendbase.data.remote.api.ApiConstants.BASE_URL
import com.ilnytskyi.spendbase.data.remote.api.card.CardApi
import com.ilnytskyi.spendbase.data.remote.api.transaction.TransactionApi
import com.ilnytskyi.spendbase.data.repository.CardRepositoryImpl
import com.ilnytskyi.spendbase.data.repository.TransactionRepositoryImpl
import com.ilnytskyi.spendbase.domain.repository.card.CardRepository
import com.ilnytskyi.spendbase.domain.repository.transaction.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCardApi(): CardApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(CardApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTransactionApi(): TransactionApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(TransactionApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCardRepository(api: CardApi): CardRepository {
        return CardRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideTransactionRepository(api: TransactionApi): TransactionRepository {
        return TransactionRepositoryImpl(api)
    }
}