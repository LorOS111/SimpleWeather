package com.example.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.ui.theme.customCardColors


@Preview(showBackground = true)
@Composable
public fun MainCard() {
    Column(
        modifier = Modifier
            .padding(5.dp),
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = customCardColors(),
            shape = RoundedCornerShape(10.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "20 june",
                        style = TextStyle(fontSize = 15.sp),
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp)
                    )
                    AsyncImage(
                        model = "https:////cdn.weatherapi.com/weather/64x64/night/113.png",
                        contentDescription = "im2",
                        modifier = Modifier
                            .padding(end = 8.dp, top = 4.dp)
                            .size(45.dp)
                    )
                }
                Text(
                    text = "Irkutsk",
                    style = TextStyle(fontSize = 30.sp),
                    color = Color.White,
                )
                Text(
                    text = "23℃",
                    style = TextStyle(fontSize = 50.sp),
                    color = Color.White,
                )
                Text(
                    text = "Sunny",
                    style = TextStyle(fontSize = 15.sp),
                    color = Color.White,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {

                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_search_24),
                            contentDescription = "im3",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = "23℃/17℃",
                        style = TextStyle(fontSize = 15.sp),
                        color = Color.White,
                    )
                    IconButton(
                        onClick = {

                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_cloud_sync_24),
                            contentDescription = "im3",
                            tint = Color.White
                        )
                    }
                }

            }
        }
    }
}
