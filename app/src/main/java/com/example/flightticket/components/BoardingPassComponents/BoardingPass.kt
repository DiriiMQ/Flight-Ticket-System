package com.example.flightticket.components.BoardingPassComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flightticket.R

@Composable
fun BoardingPass(onBackClick: () -> Unit = {}) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Header(onBackClick = onBackClick)
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .aspectRatio(0.5f),
            color = MaterialTheme.colorScheme.background
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.boarding_pass_image), // Replace with your drawable resource
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    PassDetails()
                    Divider(
                        modifier = Modifier
                            .padding(vertical = 24.dp),
                        color = MaterialTheme.colorScheme.onSurface,
                        thickness = 1.dp
                    )
                    FlightInfo()
                    Divider(
                        modifier = Modifier
                            .padding(vertical = 24.dp),
                        color = MaterialTheme.colorScheme.onSurface,
                        thickness = 1.dp
                    )
                    PassengerInfo()
                    Barcode()
                }
            }
        }
        DownloadButton()
    }
}

@Preview
@Composable
fun BoardingPassPreview() {
    BoardingPass()
}
