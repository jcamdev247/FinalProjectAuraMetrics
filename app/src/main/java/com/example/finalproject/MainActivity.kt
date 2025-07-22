package com.example.finalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.finalproject.ui.theme.FinalProjectTheme
import com.example.finalproject.BackGroundImage as Background
import com.example.finalproject.CreateScreenUI as CreateScreen
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinalProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = @Composable {}) { innerPadding ->
                    Box(modifier = Modifier.fillMaxSize().padding(innerPadding)){
                        Background(modifier = Modifier.padding(innerPadding))
                        CreateScreen(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}
