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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.data.Data
import com.example.myapplication.ui.theme.customCardColors


@Composable
fun itemInListItem(item: Data) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 3.dp,
                end = 5.dp,
                start = 5.dp
            ),
        colors = customCardColors(),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.padding(
                    start = 8.dp,
                    bottom = 3.dp,
                    top = 3.dp
                )
            ) {
                Text(
                    text = item.time,
                    color = Color.White
                )
                Text(
                    text = item.condition,
                    color = Color.White
                )
            }
            Text(
                text = item.temp.ifEmpty { "${item.maxTemp}/${item.minTemp}" },
                color = Color.White
            )
//            Image(
//                painter = painterResource(id = R.drawable.sky),
//                contentDescription = "image",
//                modifier = Modifier
//                    .fillMaxSize()
//                    .alpha(0.5f),
//                contentScale = ContentScale.FillBounds
//            )
        }
    }

}