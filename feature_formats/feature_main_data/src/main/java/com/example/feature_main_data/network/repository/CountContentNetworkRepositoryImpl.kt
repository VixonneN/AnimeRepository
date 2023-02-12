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

internal class CountContentNetworkRepositoryImpl(
    private val api: EndpointApi
) : CountContentNetworkRepository {

    //java.lang.IllegalArgumentException: Unable to create call adapter for java.util.Map<java.lang.String, com.example.feature_main_data.network.model.EndpointModel>
    override fun fetchCountContent(): Flow<DataStatus<Map<String, EndpointModel>>> = flow {
        emit(DataStatus.Loading)
        try {
            val body = api.fetchEndPoints()
            emit(DataStatus.Success(body))
        } catch (e: HttpException) {
            emit(DataStatus.Error(e.code().toHttpError()))
            e.printStackTrace()
        } catch (e: IOException) {
            emit(DataStatus.Error(e.getErrorType()))
            e.printStackTrace()
        }
    }.flowOn(Dispatchers.IO).catch {
        it.printStackTrace()
        emit(DataStatus.Error(it.getErrorType()))
    }

}