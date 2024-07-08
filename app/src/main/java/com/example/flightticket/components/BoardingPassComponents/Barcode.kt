package com.example.flightticket.components.BoardingPassComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import com.example.flightticket.R

@Composable
fun Barcode() {
    val barcodeValue = "A3427371903848"

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 24.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.barcode_image), // Replace with your drawable resource name
            contentDescription = "Barcode",
            modifier = Modifier
                .width(311.dp)
                .aspectRatio(7.69f)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = barcodeValue,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF1A1A1A) // text-zinc-950 equivalent
        )
    }
}

@Preview
@Composable
fun BarcodePreview() {
    Barcode()
}