package com.example.flightticket.components.ProfileComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightticket.R

@Composable
fun PersonalInfoField(label: String, value: String) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = label, fontSize = 12.sp, color = Color.Gray)
        Text(
            text = value,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun PersonalInformation(onBackClick: () -> Unit = {}) {
    val personalInfo = listOf(
        Pair("First Name", "Victoria"),
        Pair("Last Name", "Yoker"),
        Pair("Phone", "+380 12 345 67 89"),
        Pair("Email", "victoria.yoker@gmail.com")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
//            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .clickable(onClick = onBackClick)
                    .size(38.dp)
                    .padding(end = 8.dp)
                    .align(Alignment.CenterStart),
            )
            Text(
                text = "Personal Information",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_profile_image),
            contentDescription = "Profile",
            modifier = Modifier
                .padding(top = 24.dp)
                .size(120.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
        ) {
            personalInfo.forEach { info ->
                PersonalInfoField(label = info.first, value = info.second)
            }
        }
        Button(
            onClick = { /* Handle save changes */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800)),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .padding(top = 64.dp)
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text(text = "Save changes", fontSize = 20.sp, color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PersonalInformationPreview() {
    PersonalInformation()
}
