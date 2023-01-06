package ru.khomichenko.domain.network.use_case

import ru.khomichenko.domain.network.repository.AnimeNetworkRepository

class SleepingGifsUseCase(
    private val repository: AnimeNetworkRepository
) {

    suspend operator fun invoke() =
        repository.getSleepingGifs()
}