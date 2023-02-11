package com.example.feature_main_data.network.repository

import com.example.feature_main_data.network.api.EndpointApi
import com.example.feature_main_data.network.model.EndpointModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException
import retrofit2.HttpException
import ru.khomichenko.core.utils.DataStatus
import ru.khomichenko.core.utils.getErrorType
import ru.khomichenko.core.utils.toHttpError
import javax.inject.Inject

internal class CountContentNetworkRepositoryImpl @Inject constructor(
    private val api: EndpointApi
) : CountContentNetworkRepository {

    override fun fetchCountContent(): Flow<DataStatus<Map<String, EndpointModel>>> = flow {
        emit(DataStatus.Loading)
        try {
            val body = api.fetchEndPoints()
            emit(DataStatus.Success(body))
        } catch (e: HttpException) {
            emit(DataStatus.Error(e.code().toHttpError()))
        } catch (e: IOException) {
            emit(DataStatus.Error(e.getErrorType()))
        }
    }.flowOn(Dispatchers.IO).catch { emit(DataStatus.Error(it.getErrorType())) }

}