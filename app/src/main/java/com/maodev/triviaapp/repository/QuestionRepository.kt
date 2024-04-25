package com.maodev.triviaapp.repository

import com.maodev.triviaapp.data.DataOrException
import com.maodev.triviaapp.model.QuestionItem
import com.maodev.triviaapp.network.QuestionAPI
import javax.inject.Inject


class QuestionRepository @Inject constructor(private val questionAPI: QuestionAPI) {

    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Exception>()

    suspend fun getAllQuestion(): DataOrException<ArrayList<QuestionItem>, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = questionAPI.getAllQuestion()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        } catch (exception: Exception) {
            dataOrException.exception = exception
        }
        return dataOrException
    }
}