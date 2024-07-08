package com.example.flightticket.components.BookingsComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DateSelector(dates: List<DateItem>) {
    Column(modifier = Modifier.fillMaxWidth().padding(top = 24.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            dates.forEachIndexed { index, date ->
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(
                            color = if (index == 0) Color(0xFFFFB085) else Color.Transparent,
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(8.dp)
                ) {
                    Text(
                        text = date.day,
                        fontSize = 12.sp,
                        lineHeight = 20.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = date.date,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

data class DateItem(val day: String, val date: String)

val dates = listOf(
    DateItem("Mon", "12"),
    DateItem("Tue", "13"),
    DateItem("Wed", "14"),
    DateItem("Thu", "15"),
    DateItem("Fri", "16"),
    DateItem("Sat", "17"),
    DateItem("Sun", "18")
)

@Preview
@Composable
fun DateSelectorPreview() {
    DateSelector(dates)
}