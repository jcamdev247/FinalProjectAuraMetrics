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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalproject.ui.theme.FinalProjectTheme

@Composable
fun BodyFatPercentagePage(
    modifier: Modifier = Modifier,
    viewModel: BodyFatCalculationViewModel = viewModel()
) {
    val maleString = stringResource(R.string.male)
    val femaleString = stringResource(R.string.female)
    val rowSpacer: Dp = 10.dp
    val columnBottomPadding: Dp = 100.dp
    val uiState by viewModel.uiState.collectAsState()

    BackGroundImage(modifier = modifier, false)

    ColumnSpacerHeightMethod(rowSpacer)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = columnBottomPadding)
            .padding(rowSpacer),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {

        SetupBodyFatInstructions(rowSpacer, uiState.submitButtonPressed, uiState)

        Spacer(modifier = Modifier.width(rowSpacer))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = maleString)
            RadioButton(selected = uiState.userGenderInput == maleString, onClick = { viewModel.updateGender(maleString)})

            Text(text = femaleString)
            RadioButton(selected = uiState.userGenderInput == femaleString, onClick = { viewModel.updateGender(femaleString)})
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.enter_user_age_label)
            )

    Spacer(modifier = Modifier.width(rowSpacer))

            TextField(value = uiState.userAgeInput ?: "", onValueChange = { newValue -> viewModel.updateAge(newValue) })
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
                value = uiState.userWeightInput ?: "", onValueChange = { newValue -> viewModel.updateWeight(newValue)})
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
                value = uiState.userHeightInput ?: "", onValueChange = { newValue -> viewModel.updateHeight(newValue) })
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
                value = uiState.userNeckInput ?: "", onValueChange = { newValue -> viewModel.updateNeck(newValue)})

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
                value = uiState.userWaistInput ?: "", onValueChange = { newValue -> viewModel.updateWaist(newValue)})
        }

        if (uiState.userGenderInput == "Female") {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.enter_user_Hip_circumference_label)
                )
                Spacer(modifier = Modifier.width(rowSpacer))
                TextField(
                    value = uiState.userHipInput ?: "", onValueChange = { newValue -> viewModel.updateHip(newValue )}
                )
            }
        }

Spacer(modifier = Modifier.width(rowSpacer))

        FilledTonalButton( onClick = {

            if (uiState.userGenderInput == null || uiState.userAgeInput == null || uiState.userWeightInput == null || uiState.userHeightInput == null || uiState.userWaistInput == null || uiState.userNeckInput == null || uiState.userHipInput == null && uiState.userGenderInput == "Female") {
                return@FilledTonalButton
            }

            viewModel.updateSubmitButtonPressed()
            viewModel.calculateBodyFatPercentageSwitch()
            }) {
            Text(text = stringResource(R.string.submit_measurements_button))
        }
    }
}

@Composable
fun SetupBodyFatInstructions(rowSpacer: Dp, submitted: Boolean, uiState: BodyFatCalculationState) {
    val textStyle =TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)

    if (!submitted) {
        Text(
            text = stringResource(R.string.instruction_lable_1), style = textStyle
        )
        ColumnSpacerHeightMethod(rowSpacer)
        Text(
            text = stringResource(R.string.instruction_lable_2),style = textStyle
        )
        ColumnSpacerHeightMethod(rowSpacer)
        Text(
            text = stringResource(R.string.instruction_lable_3), style = textStyle
        )
    } else {
        val calculatedBfp = uiState.bfp ?: ""
        val totalBodyFat = uiState.totalBodyFatMass ?: ""
        val totalLeanMass = uiState.leanBodyMass ?: ""
        Text("BFP: $calculatedBfp ", style = textStyle)
        Text("Total Body Fat Mass: $totalBodyFat ", style = textStyle)
        Text("Lean Mass: $totalLeanMass ", style = textStyle)
    }
}

@Composable
fun ColumnSpacerHeightMethod(rowSpacer: Dp) {
    Spacer(modifier = Modifier.height(rowSpacer))
}

@Preview(showBackground = true)
@Composable
fun SetUpBodyFatPercentagePreview() {
    FinalProjectTheme {
        BodyFatPercentagePage(modifier = Modifier)
    }
}