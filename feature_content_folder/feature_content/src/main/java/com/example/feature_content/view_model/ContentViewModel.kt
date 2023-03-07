package com.example.feature_content.view_model

import android.graphics.Bitmap
import android.os.Environment
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.example.feature_content.states.ContentEvent
import com.example.feature_content.states.ContentScreenState
import com.example.feature_content.states.ContentSideEffect
import com.example.feature_content_data.network.repository.ContentNetworkRepository
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import ru.khomichenko.core.utils.ContentType
import ru.khomichenko.core.utils.DataStatus
import ru.khomichenko.core.utils.MviViewModel
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.nio.ByteBuffer
import java.util.*

class ContentViewModel(
    private val contentNetworkRepository: ContentNetworkRepository
) : MviViewModel<ContentScreenState, ContentSideEffect, ContentEvent>(
    initialState = ContentScreenState()
) {

    override fun dispatch(event: ContentEvent) {
        when (event) {
            is ContentEvent.LoadContent -> {
                loadContent(content = event.type, contentType = event.typeContent)
            }
            is ContentEvent.LoadGif -> downloadGif(event.gifDrawable)
            is ContentEvent.LoadPng -> downloadImage(event.url)
        }
    }

    private fun loadContent(content: String, contentType: String) {
        when (contentType) {
            ContentType.PNG.type -> loadImageContent(nameContent = content)
            ContentType.GIF.type -> loadGifContent(nameContent = content)
        }
    }

    private fun loadImageContent(nameContent: String) {
        intent {
            viewModelScope.launch {
                contentNetworkRepository.loadImageContent(content = nameContent).collect { status ->
                    when (status) {
                        is DataStatus.Loading -> {
                            reduce { state.copy(loading = true) }
                        }
                        is DataStatus.Success -> {
                            reduce {
                                state.copy(
                                    loading = false,
                                    listImagesData = status.data.listResult
                                )
                            }
                        }
                        is DataStatus.Error -> {
                            reduce {
                                state.copy(
                                    loading = false,
                                    errorMessage = status.errorType
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun loadGifContent(nameContent: String) {
        intent {
            viewModelScope.launch {
                contentNetworkRepository.loadGifContent(content = nameContent.filter { !it.isWhitespace() })
                    .collect { status ->
                        when (status) {
                            is DataStatus.Loading -> {
                                reduce { state.copy(loading = true) }
                            }
                            is DataStatus.Success -> {
                                reduce {
                                    state.copy(
                                        loading = false,
                                        listGifsData = status.data.listGifResult
                                    )
                                }
                            }
                            is DataStatus.Error -> {
                                reduce {
                                    state.copy(
                                        loading = false,
                                        errorMessage = status.errorType
                                    )
                                }
                            }
                        }
                    }
            }
        }
    }

    //todo в будущем вынести в worker
    private fun downloadImage(bitmap: Bitmap) {
        try {
            val path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS
            )
            val file = File(path, "/${UUID.randomUUID()}.png") //todo custom name
            val fileOutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun downloadGif(gifDrawable: GifDrawable) {

        val byteBuffer = gifDrawable.buffer

        try {
            val path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS
            )
            val file = File(path, "/${UUID.randomUUID()}.gif")
            val fileOutputStream = FileOutputStream(file)
            val bytes = ByteArray(byteBuffer.capacity())
            (byteBuffer.duplicate().clear() as ByteBuffer).get(bytes)
            fileOutputStream.write(bytes, 0, bytes.size)
            fileOutputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}