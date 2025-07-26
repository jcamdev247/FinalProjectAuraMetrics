package com.example.finalproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.finalproject.ui.theme.FinalProjectTheme

@Composable
fun CreateScreenUI(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        FilledTonalButton(onClick = { }) {
            Text(text = stringResource(R.string.oneRepMaxLabel))
        }

        FilledTonalButton(onClick = {

        }) {
            Text(text = stringResource(R.string.bFPercentageLabel))
        }

        FilledTonalButton(onClick = { }) {
            Text(text = stringResource(R.string.tDEELabel))
        }

        FilledTonalButton(onClick = { }) {
            Text(text = stringResource(R.string.analyzeLiftsLabel))
        }

        FilledTonalButton(onClick = { }) {
            Text(text = stringResource(R.string.strengthStandardsLabel))
        }
    }
}



@Preview(showBackground = true)
@Composable
fun CreateScreenPreview() {
    FinalProjectTheme {
        CreateScreenUI()
    }
}

