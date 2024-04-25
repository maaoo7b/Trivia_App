package com.maodev.triviaapp.data

data class DataOrException<T, E : Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var exception: E? = null
)
