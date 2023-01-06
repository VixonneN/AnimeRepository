package ru.khomichenko.core.utils

import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

enum class ErrorType {
    Unauthorized,
    Forbidden,
    NotFound,
    NoInternetConnection,
    BadInternetConnection,
    SocketTimeOut,
    Unknown
}

fun Throwable.getErrorType(): ErrorType {
    return when(this) {
        is ConnectException -> ErrorType.NoInternetConnection
        is UnknownHostException -> ErrorType.BadInternetConnection
        is SocketTimeoutException -> ErrorType.SocketTimeOut
        else -> ErrorType.Unknown
    }
}
