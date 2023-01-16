package ru.khomichenko.domain.network.use_case

import ru.khomichenko.domain.network.repository.AnimeNetworkRepository
import javax.inject.Inject

class SleepingGifsUseCase @Inject constructor(
    private val repository: AnimeNetworkRepository
) {
    suspend operator fun invoke() =
        repository.getSleepingGifs()
}