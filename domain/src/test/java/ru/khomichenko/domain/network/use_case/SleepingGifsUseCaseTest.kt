package ru.khomichenko.domain.network.use_case

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito
import ru.khomichenko.core.utils.DataStatus
import ru.khomichenko.core.utils.ErrorType
import ru.khomichenko.domain.network.entity.GifValueEntity
import ru.khomichenko.domain.network.entity.GifsResponseEntity
import ru.khomichenko.domain.network.repository.AnimeNetworkRepository

internal class SleepingGifsUseCaseTest {

    private val entity = GifsResponseEntity(
        listResult = listOf(
            GifValueEntity(
                animeName = "Naruto",
                url = "https://naruto.com"
            )
        )
    )

    private val testEntity =
        DataStatus.Success(entity)

    private fun testDataStatusSuccess() : DataStatus<GifsResponseEntity> =
        DataStatus.Success(entity)

    private fun testDataStatusError() : DataStatus<GifsResponseEntity> =
        DataStatus.Error(ErrorType.NotFound)


    //todo
    @Test
    fun `WHEN make request GET data`() = runBlocking {
        val mockRepository = Mockito.mock(AnimeNetworkRepository::class.java)
        val testResponse = testDataStatusSuccess()

        Mockito.`when`(mockRepository.getSleepingGifs()).thenReturn(testResponse)
        val actualResponse = SleepingGifsUseCase(mockRepository)()

        assertEquals(testResponse, actualResponse)
    }

    @Test
    fun `WHEN make request GET 404 error`() = runBlocking {
        val mockRepository = Mockito.mock(AnimeNetworkRepository::class.java)
        val testResponse = testDataStatusError()

        Mockito.`when`(mockRepository.getSleepingGifs()).thenReturn(testResponse)
        val actualResponse = SleepingGifsUseCase(mockRepository)()

        assertEquals(testResponse, actualResponse)
    }

}