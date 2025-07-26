package com.example.finalproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
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


@Composable
fun BackGroundImage(modifier: Modifier = Modifier, displayDecorations: Boolean) {
    val backgroundImagePicture = painterResource(R.drawable.background)

    Image(
        painter = backgroundImagePicture,
        contentDescription = "background for application",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )

    if(displayDecorations){
        Box(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .padding(top = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.app_name),
                modifier = modifier,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        Column(modifier = modifier.fillMaxSize().padding(top = 30.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top){
            val logoImage = painterResource(R.drawable.kingkailogo200highdensity)

            Image(
                painter = logoImage,
                contentDescription = "logo for application",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.size(300.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SetUpBackGround() {
    FinalProjectTheme {
        BackGroundImage(modifier = Modifier, true)
    }
}