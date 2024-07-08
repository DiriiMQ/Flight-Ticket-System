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
fun FlightInfo() {
    Column(
        modifier = Modifier.padding(top = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Text(
                    text = "NYC",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF065F46) // text-teal-800 equivalent
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "New York",
                    fontSize = 16.sp,
                    color = Color(0xFF1A1A1A) // text-zinc-950 equivalent
                )
            }
            Image(
                painter = painterResource(id = R.drawable.f_loading), // Replace with your drawable resource name
                contentDescription = "Flight path",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .width(110.dp)
                    .aspectRatio(4.76f)
            )
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = "LDN",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF065F46) // text-teal-800 equivalent
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "London",
                    fontSize = 16.sp,
                    color = Color(0xFF1A1A1A) // text-zinc-950 equivalent
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Text(
                    text = "Date",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF065F46) // text-teal-800 equivalent
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "02 Jun",
                    fontSize = 16.sp,
                    color = Color(0xFF1A1A1A) // text-zinc-950 equivalent
                )
            }
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = "Departure",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF065F46) // text-teal-800 equivalent
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "9:00 AM",
                    fontSize = 16.sp,
                    color = Color(0xFF1A1A1A) // text-zinc-950 equivalent
                )
            }
        }
    }
}

@Preview
@Composable
fun FlightInfoPreview() {
    FlightInfo()
}