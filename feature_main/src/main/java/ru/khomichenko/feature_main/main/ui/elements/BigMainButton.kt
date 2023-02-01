package ru.khomichenko.feature_main.main.ui.elements

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BigMainButton(text: String, onClick:() -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .height(150.dp)
            .background(MaterialTheme.colors.primary, RoundedCornerShape(20.dp))
            .border(2.dp, MaterialTheme.colors.secondary, RoundedCornerShape(20.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 48.sp,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Italic,
            color = Color.White
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BigMainButtonPreview() {
    BigMainButton(text = "Gifs") {
        
    }
}