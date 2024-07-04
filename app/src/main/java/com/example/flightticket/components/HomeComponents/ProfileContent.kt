package com.example.flightticket.components.HomeComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.flightticket.R
import com.example.flightticket.components.ProfileComponents.PersonalInformation

@Composable
fun MenuOption(icon: Int, text: String, onClick: () -> Unit = {}) {
    Row(modifier = Modifier
        .clickable(onClick = onClick)
        .padding(vertical = 6.dp, horizontal = 20.dp)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .padding(end = 8.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = text,
            modifier = Modifier.align(Alignment.CenterVertically),
            fontSize = 16.sp
        )
    }
}

@Composable
fun MainProfileContent(onPersonalInformationClick : () -> Unit = {}) {
    val menuOptions = listOf(
        R.drawable.ic_personal_information to "Personal information",
        R.drawable.ic_payment_and_cards to "Payment and cards",
        R.drawable.ic_saved to "Saved",
        R.drawable.ic_booking_history to "Booking history",
        R.drawable.ic_settings to "Settings"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Account",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_profile_image),
            contentDescription = "Victoria Yoker's profile",
            modifier = Modifier
                .size(100.dp)
                .padding(top = 16.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Victoria Yoker",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
        Column(modifier = Modifier.padding(top = 24.dp)) {
            menuOptions.forEach { option ->
                MenuOption(
                    icon = option.first,
                    text = option.second,
                    onClick = {
                        if (option.second == "Personal information") {
                            onPersonalInformationClick()
                        }
                    }
                )
            }
        }
        Button(
            onClick = { /* End session logic */ },
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = RoundedCornerShape(24.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_end_session),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "End session",
                    color = Color.Red,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun ProfileContent() {
    var currentScreen by remember { mutableStateOf("Home") }

    when (currentScreen) {
        "Home" -> MainProfileContent(
            onPersonalInformationClick = { currentScreen = "PersonalInformation" }
        )
        "PersonalInformation" -> PersonalInformation(
            onBackClick = { currentScreen = "Home" }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyComponent() {
    ProfileContent()
}
