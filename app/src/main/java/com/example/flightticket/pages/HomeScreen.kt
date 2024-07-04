package com.example.flightticket.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import com.example.flightticket.R

@SuppressLint("ResourceAsColor")
@Composable
fun BookingService(icon: Painter, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(4.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(60.dp)
                .background(
                    Color(0xFF01635D),
                    RoundedCornerShape(30.dp)
                )
        ) {
            Image(
                painter = icon,
                contentDescription = "$label icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(32.dp)
            )
        }
        Text(
            text = label,
            style = TextStyle(fontSize = 12.sp, color = Color(0xFF1C1B1F)),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun NavItem(icon: Painter, label: String, isActive: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .padding(4.dp)
            .background(
                if (isActive) Color(0xFFFFE0B2) else Color.Transparent,
                RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Image(
            painter = icon,
            contentDescription = "$label icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(24.dp)
        )
        if (isActive) {
            Text(
                text = label,
                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.SemiBold),
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier=Modifier
        .fillMaxSize()
        .background(Color(0xFFF5F5F5))
) {
    val bookingServices = listOf(
        BookingServiceData(painterResource(id = R.drawable.trips), "Trips"),
        BookingServiceData(painterResource(id = R.drawable.hotel), "Hotel"),
        BookingServiceData(painterResource(id = R.drawable.transport), "Transport"),
        BookingServiceData(painterResource(id = R.drawable.events), "Events")
    )

    val navItems = listOf(
        NavItemData(painterResource(id = R.drawable.ic_home), "Home", true),
        NavItemData(painterResource(id = R.drawable.ic_search), "Search", false),
        NavItemData(painterResource(id = R.drawable.ic_bookings), "Bookings", false),
        NavItemData(painterResource(id = R.drawable.ic_profile), "Profile", false)
    )

    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 32.dp)
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
                    .padding(horizontal = 16.dp, vertical = 8.dp)
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
                        modifier = Modifier.size(24.dp)
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

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(24.dp))
                .padding(8.dp)
                .align(Alignment.BottomCenter)
                .height(45.dp)
                .fillMaxWidth()
        ) {
            navItems.forEach { item ->
                NavItem(icon = item.icon, label = item.label, isActive = item.isActive)
            }
        }
    }

//    Spacer(modifier = Modifier.height(16.dp))
}

data class BookingServiceData(val icon: Painter, val label: String)
data class NavItemData(val icon: Painter, val label: String, val isActive: Boolean)

@Preview(showBackground = true)
@Composable
fun PreviewMyComponent() {
    HomeScreen()
}
