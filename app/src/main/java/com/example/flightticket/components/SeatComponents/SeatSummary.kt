package com.example.flightticket.components.SeatComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightticket.R

@Composable
fun SeatSummary(selectedSeats: List<String>, numPeople: Int, unitPrice: Double, onSubmitClick: () -> Unit = {}) {
    val totalPrice = selectedSeats.size * unitPrice

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 20.dp)
            .background(color = Color.White, shape = RoundedCornerShape(24.dp))
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Your seats",
                    color = colorResource(id = R.color.teal_800),
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium)
                )
                Text(
                    text = selectedSeats.joinToString(" "),
                    color = colorResource(id = R.color.zinc_950),
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Total price",
                    color = colorResource(id = R.color.teal_800),
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium)
                )
                Text(
                    text = "$${"%.2f".format(totalPrice)}",
                    color = colorResource(id = R.color.zinc_950),
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold)
                )
            }
        }
        Button(
            onClick = { onSubmitClick() },
            enabled = selectedSeats.size == numPeople,
            modifier = Modifier
                .padding(horizontal = 40.dp, vertical = 16.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange_300)),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(
                text = "Continue",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun SeatSummaryPreview() {
    SeatSummary(selectedSeats = listOf("A1", "A2", "A3"), numPeople = 3, unitPrice = 25.0)
}