package com.example.quotz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.quotz.screens.QuoteDetailScreen
import com.example.quotz.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)

        }
        setContent {
            App()
        }
    }
}

@Composable
fun App(){
    if(DataManager.isDataLoaded.value){
        if(DataManager.currentPage.value==Pages.LISTING){

            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        }
        else{
            DataManager.currentQuote?.let { QuoteDetailScreen(quote = it) }
        }
    }
    else{

        Box(
            contentAlignment = Alignment.Center, // Center the content
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Loading...", style = MaterialTheme.typography.titleLarge)
        }    }
}

enum class Pages{
    LISTING,
    DETAIL
}
