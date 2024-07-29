package com.example.quotz.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quotz.R
import com.example.quotz.models.Quote


@Composable
fun quoteListItem(quote: Quote,onClick: (quote:Quote)->Unit) {
    Card(elevation = CardDefaults.cardElevation(4.dp), modifier = Modifier.padding(8.dp).clickable { onClick(quote) }, colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Row(Modifier.padding(16.dp)) {
            Image(painter = painterResource(id = R.drawable.baseline_format_quote_24), contentDescription = "",
                Modifier
                    .background(
                        Color.Black
                    )
                    .size(45.dp)
                    .rotate(180F)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column(Modifier.weight(1f)) {
                Text(text = quote.quote, style = MaterialTheme.typography.labelLarge , modifier = Modifier.padding(0.dp,0.dp,0.dp,8.dp))

                Box(modifier = Modifier
                    .background(Color(0xFFB0B0B0))
                    .fillMaxWidth(.4f)
                    .height(1.dp))
                Text(text = quote.author, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Light , modifier = Modifier.padding(top=4.dp))


            }
        }
    }
}

