package com.example.finalproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.finalproject.ui.theme.FinalProjectTheme


@Composable
fun BodyFatPercentagePage(modifier: Modifier = Modifier) {
    val male = stringResource(R.string.male)
    val female = stringResource(R.string.female)
    var userGenderInput by remember { mutableStateOf("") }
    var userAgeInput by remember { mutableStateOf("") }
    var userWeightInput by remember { mutableStateOf("") }
    var userHeightInput by remember { mutableStateOf("") }
    var userNeckInput by remember { mutableStateOf("") }
    var userWaistInput by remember { mutableStateOf("") }
    val rowSpacer: Dp = 10.dp
    val columnTopPadding: Dp = 20.dp
    val columnBottomPadding: Dp = 112.dp

    BackGroundImage(modifier = modifier, false)
    Column(

        modifier = modifier
            .fillMaxSize()
            .padding(columnTopPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        Text(
            text = stringResource(R.string.instruction_lable_1)
        )
        Spacer(modifier = Modifier.height(rowSpacer))
        Text(
            text = stringResource(R.string.instruction_lable_2)
        )
        Spacer(modifier = Modifier.height(rowSpacer))
        Text(
            text = stringResource(R.string.instruction_lable_3)
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = columnBottomPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = male)
            RadioButton(selected = false, onClick = { userGenderInput = male })

            Text(text = female)
            RadioButton(selected = false, onClick = { userGenderInput = female })
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.enter_user_age_label)
            )

            Spacer(modifier = Modifier.width(rowSpacer))

            TextField(value = userAgeInput, onValueChange = { newValue -> userAgeInput = newValue })
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.enter_user_weight_label)
            )

            Spacer(modifier = Modifier.width(rowSpacer))

            TextField(
                value = userWeightInput, onValueChange = { newValue -> userWeightInput = newValue })
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.enter_user_height_label)
            )

            Spacer(modifier = Modifier.width(rowSpacer))

            TextField(
                value = userHeightInput, onValueChange = { newValue -> userHeightInput = newValue })
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.enter_user_neck_circumference_label)
            )

            Spacer(modifier = Modifier.width(rowSpacer))

            TextField(
                value = userNeckInput, onValueChange = { newValue -> userNeckInput = newValue })
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.enter_user_waist_circumference_label)
            )

            Spacer(modifier = Modifier.width(rowSpacer))

            TextField(
                value = userWaistInput, onValueChange = { newValue -> userWaistInput = newValue })
        }

        FilledTonalButton(onClick = { }) {
            Text(text = stringResource(R.string.submit_measurements_button))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SetUpBodyFatPercentagePreview() {
    FinalProjectTheme {
        BodyFatPercentagePage(modifier = Modifier)
    }
}