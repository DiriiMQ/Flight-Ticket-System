package com.example.flightticket.components.BoardingPassComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import com.example.flightticket.R

@Composable
fun PassDetails() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .width(200.dp), // Equivalent to w-52,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.british_airways_logo), // Replace with your drawable resource name
            contentDescription = "British Airways logo",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.33f)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "British Airways Flight NL-41",
            fontSize = 16.sp,
            color = Color(0xFF1A1A1A) // text-zinc-950 equivalent
        )
    }
}

@Preview
@Composable
fun PassDetailsPreview() {
    PassDetails()
}
