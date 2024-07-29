package com.example.quotz.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotz.R
import com.example.quotz.models.Quote

@Composable
fun QuoteListScreen(data:Array<Quote>,onClick:(quote:Quote)->Unit){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text="Quotz",textAlign = TextAlign.Center, modifier = Modifier.padding(8.dp,24.dp).fillMaxWidth(1f), style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.W900, fontFamily = FontFamily(
            Font(R.font.montsserat_regular),
        ))
        QuoteList(data = data,onClick)
    }
}