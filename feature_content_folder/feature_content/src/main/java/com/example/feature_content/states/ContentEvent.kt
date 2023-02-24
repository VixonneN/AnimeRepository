package com.example.feature_content.states

import android.graphics.Bitmap
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.example.feature_content_data.network.model.DataImagesResults

sealed class ContentEvent {
    data class LoadContent(val typeContent: String, val type: String) : ContentEvent()

    class LoadGif(val gifDrawable: GifDrawable): ContentEvent()
    class LoadPng(val url: Bitmap): ContentEvent()
    data class ShowContent(val content: List<DataImagesResults>)
}