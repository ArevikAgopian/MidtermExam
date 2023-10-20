package com.example.midtermexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.midtermexam.ui.theme.MidtermExamTheme
import java.lang.Math.abs
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            bullsEyeGame()
            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bullsEyeGame() {
    var targetValue by remember { mutableStateOf(50) }
    var sliderValue by remember { mutableStateOf(50f) }
    var difference by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(100) }
    var showScore by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bull's Eye Game", // Set the title here
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Put the slider as close as you can to $targetValue", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Slider(
            value = sliderValue,
            onValueChange = {
                sliderValue = it
                difference = (abs(it - targetValue).roundToInt())
                score = 100 - difference
            },
            valueRange = 0f..100f
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "You are off by $difference",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { showScore = true },

        ) {
            Text("Hit Me")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (showScore) {
            Text(
                text = "Perfect! You scored: $score points",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MidtermExamTheme {
        bullsEyeGame()
    }
}