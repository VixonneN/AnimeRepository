package com.example.feature_content_data.network.repository

import com.example.feature_content_data.network.api.EndpointApi
import com.example.feature_content_data.network.model.ResponseGifResult
import com.example.feature_content_data.network.model.ResponseImageResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException
import retrofit2.HttpException
import ru.khomichenko.core.utils.DataStatus
import ru.khomichenko.core.utils.ErrorType
import ru.khomichenko.core.utils.getErrorType
import ru.khomichenko.core.utils.toHttpError

internal class ContentNetworkRepositoryImpl(
    private val api: EndpointApi
) : ContentNetworkRepository {


    override fun loadImageContent(content: String): Flow<DataStatus<ResponseImageResult>> =
        flow {
            emit(DataStatus.Loading)
            try {
                //todo in future
                val body = api.getContentSource(content = content, amount = STANDARD_AMOUNT)
                emit(DataStatus.Success(body))
            } catch (e: IOException) {
                emit(DataStatus.Error(e.getErrorType()))
            } catch (e: HttpException) {
                emit(DataStatus.Error(e.code().toHttpError()))
            }
        }
            .flowOn(Dispatchers.IO)
            .catch { DataStatus.Error(ErrorType.BadInternetConnection) }

    override fun loadGifContent(content: String): Flow<DataStatus<ResponseGifResult>> =
        flow {
            emit(DataStatus.Loading)
            try {
                val body = api.getGifContent(content = content, amount = STANDARD_AMOUNT)
                emit(DataStatus.Success(body))
            } catch (e: IOException) {
                emit(DataStatus.Error(e.getErrorType()))
            } catch (e: HttpException) {
                emit(DataStatus.Error(e.code().toHttpError()))
            }
        }
            .flowOn(Dispatchers.IO)
            .catch { DataStatus.Error(ErrorType.BadInternetConnection) }

    companion object {
        private const val STANDARD_AMOUNT = 20
    }
}