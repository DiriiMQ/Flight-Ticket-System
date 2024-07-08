package com.example.flightticket.components.BookingsComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.flightticket.R

@Composable
fun FlightCard(
    fromCode: String,
    fromCity: String,
    toCode: String,
    toCity: String,
    date: String,
    departure: String,
    price: String,
    number: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
//    Column(
//        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxWidth()
////            .background(Color(0xFF000000))
//    ) {
//        Surface(
//            modifier = Modifier
//                .fillMaxWidth()
//                .clip(RoundedCornerShape(8.dp)),
//            color = MaterialTheme.colorScheme.surface
//        ) {
    Box (
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = R.drawable.f_bg), // Replace with your drawable resource
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2.04f),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(16.dp)
                .padding(top = 8.dp)
                .padding(bottom = 8.dp)
        ) {
//            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            ) {
                Column {
                    Text(
                        text = fromCode,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = fromCity,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.f_loading), // Replace with your drawable resource
                    contentDescription = "Flight path",
                    modifier = Modifier
                        .width(130.dp)
                        .height(24.dp)
                )
                Column {
                    Text(
                        text = toCode,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = toCity,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
//            Spacer(modifier = Modifier.height(16.dp))
            Divider(
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                modifier = Modifier.align(Alignment.Center)
            )
//            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                Column {
                    Text(
                        text = "Date",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = date,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Column {
                    Text(
                        text = "Departure",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = departure,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Column {
                    Text(
                        text = "Price",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = price,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Column {
                    Text(
                        text = "Number",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = number,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}
//        }
//    }

@Preview(showBackground = false)
@Composable
fun FlightCardPreview() {
    FlightCard(
        fromCode = "JFK",
        fromCity = "New York",
        toCode = "LHR",
        toCity = "London",
        date = "Jun 02, 2022",
        departure = "10:00 AM",
        price = "$499",
        number = "A380"
    )
}