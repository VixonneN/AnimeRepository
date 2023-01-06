package ru.khomichenko.main_data.network.mapper

import ru.khomichenko.domain.network.entity.GifValueEntity
import ru.khomichenko.domain.network.entity.GifsResponseEntity
import ru.khomichenko.main_data.network.dto.gif.GifValueDto
import ru.khomichenko.main_data.network.dto.gif.GifsResponseDto

fun GifValueDto.toEntity() =
    GifValueEntity(
        animeName = animeName,
        url = url
    )

fun GifsResponseDto.toEntity() =
    GifsResponseEntity(
        listResult.map { it.toEntity() }
    )