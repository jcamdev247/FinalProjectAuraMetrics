package com.example.finalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finalproject.ui.theme.FinalProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinalProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = @Composable {}) { innerPadding ->
                    BackGroundImage(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun BackGroundImage(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.background)
    Image(
        painter = image,
        contentDescription = "background for application",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )

    Box(modifier = Modifier.fillMaxWidth().padding(top = 20.dp), contentAlignment = Alignment.Center){
        Text(
            text = stringResource(R.string.app_name),
            modifier = modifier,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SetUpBackGround() {
    FinalProjectTheme {
        BackGroundImage(modifier = Modifier)
    }
}