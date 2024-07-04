package com.example.flightticket.components.HomeComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightticket.R
import com.example.flightticket.pages.BookingService
import com.example.flightticket.pages.BookingServiceData

@Composable
fun HomeContent() {
    val bookingServices = listOf(
        BookingServiceData(painterResource(id = R.drawable.trips), "Trips"),
        BookingServiceData(painterResource(id = R.drawable.hotel), "Hotel"),
        BookingServiceData(painterResource(id = R.drawable.transport), "Transport"),
        BookingServiceData(painterResource(id = R.drawable.events), "Events")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Explore the beautiful world!",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF1C1B1F)
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        var searchText by remember { mutableStateOf("") }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(16.dp))
                .padding(horizontal = 16.dp, vertical = 4.dp)
                .fillMaxWidth()
        ) {
            BasicTextField(
                value = searchText,
                onValueChange = { searchText = it },
                textStyle = TextStyle(fontSize = 14.sp, color = Color(0xFF757575)),
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = { /* Handle search click */ }) {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search icon",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            Text(
                text = "Booking Services",
                style = TextStyle(fontSize = 16.sp, color = Color(0xFF1C1B1F)),
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                bookingServices.forEach { service ->
                    BookingService(icon = service.icon, label = service.label)
                }
            }
        }
    }
}