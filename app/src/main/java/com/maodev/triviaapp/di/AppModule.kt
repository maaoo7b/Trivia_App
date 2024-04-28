package com.maodev.triviaapp.di

import android.provider.SyncStateContract.Constants
import com.maodev.triviaapp.model.Question
import com.maodev.triviaapp.network.QuestionAPI
import com.maodev.triviaapp.repository.QuestionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideQuestionAPI(): QuestionAPI {
        return Retrofit.Builder()
            .baseUrl(com.maodev.triviaapp.utils.Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideQuestionRepository(api: QuestionAPI) = QuestionRepository(api)


}