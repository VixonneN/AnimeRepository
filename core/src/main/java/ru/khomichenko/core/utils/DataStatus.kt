package ru.khomichenko.core.utils

import retrofit2.Response

sealed class DataStatus<out T> {
    object Loading: DataStatus<Nothing>()
    data class Success<out R>(val data: R): DataStatus<R>()
    data class Error(val errorType: ErrorType): DataStatus<Nothing>()
}

fun Int.toHttpError() : ErrorType =
    when(this) {
        401 -> ErrorType.Unauthorized
        403 -> ErrorType.Forbidden
        404 -> ErrorType.NotFound
        else -> ErrorType.Unknown
    }


fun <T> Response<T>.toDataStatus() : DataStatus<T> =
    if (this.isSuccessful) {
        DataStatus.Success(data = body()!!)
    } else {
        val errorType = when (this.code()) {
            401 -> ErrorType.Unauthorized
            403 -> ErrorType.Forbidden
            404 -> ErrorType.NotFound
            else -> ErrorType.Unknown
        }
        DataStatus.Error(errorType = errorType)
    }

