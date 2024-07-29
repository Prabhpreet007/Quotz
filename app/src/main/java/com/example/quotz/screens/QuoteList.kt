package com.example.quotz.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quotz.models.Quote

@Composable
fun QuoteList(data: Array<Quote>,onClick:(quote:Quote)->Unit){
    LazyColumn(content = {
        items(data){
            quoteListItem(quote = it,onClick)
        }
    })
}