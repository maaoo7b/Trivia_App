package com.maodev.triviaapp.network

import com.maodev.triviaapp.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionAPI {

    @GET("world.json")
    suspend fun getAllQuestion(): Question
}