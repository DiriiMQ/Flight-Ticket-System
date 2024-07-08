package com.example.flightticket.components.BookingsComponents

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightticket.R

@Composable
fun TransportOption(icon: Int, isSelected: Boolean) {
    val backgroundColor = if (isSelected) Color(0xFF008080) else Color.White

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(4.dp)
            .size(50.dp)
            .background(backgroundColor, shape = RoundedCornerShape(12.dp))
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun ClassOption(label: String, isSelected: Boolean) {
    val backgroundColor = if (isSelected) Color(0xFF008080) else Color.White
    val textColor = if (isSelected) Color.White else Color(0xFF008080)

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(4.dp)
            .background(backgroundColor, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = label, color = textColor)
    }
}

@Composable
fun DateSelector(label: String, date: String) {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = label, fontSize = 12.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = date, fontSize = 16.sp, color = Color.Black)
    }
}

@Composable
fun TransportContent(
    onBackClick: () -> Unit = {},
    onSearchClick: () -> Unit = {}
) {
    val transportOptions = remember {
        listOf(
            Pair(R.drawable.tp_flight, true),
            Pair(R.drawable.tp_ship, false),
            Pair(R.drawable.tp_train, false),
            Pair(R.drawable.tp_bus, false)
        )
    }

    val classOptions = remember {
        listOf(
            Pair("Economy", false),
            Pair("Business", true)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
//            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterStart)
                    .clickable(onClick = onBackClick)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Transport Booking",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(text = "From", fontSize = 12.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "New York (NYC)", fontSize = 16.sp, color = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Column {
                    Text(text = "To", fontSize = 12.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "London (LDN)", fontSize = 16.sp, color = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                DateSelector(label = "Departure", date = "Jun 02, 2022")
                DateSelector(label = "Return", date = "Jun 12, 2022")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Passenger & Luggage",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Replace with your passenger and luggage icons and logic

        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Class",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            classOptions.forEach { option ->
                ClassOption(label = option.first, isSelected = option.second)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Transport",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            transportOptions.forEach { option ->
                TransportOption(icon = option.first, isSelected = option.second)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onSearchClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .background(Color(0xFFFEA36B), shape = RoundedCornerShape(24.dp))
                .padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor =  Color(0xFFFEA36B))
        ) {
            Text(text = "Search", fontSize = 18.sp, color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TransportContentPreview() {
    TransportContent()
}