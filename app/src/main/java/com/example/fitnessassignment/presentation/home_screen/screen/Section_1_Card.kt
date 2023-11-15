package com.example.fitnessassignment.presentation.home_screen.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessassignment.R
import com.example.fitnessassignment.presentation.home_screen.state.MainViewState

@Composable
fun Section_1_Card(state: MainViewState) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(20.dp),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(3.dp),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painterResource(R.drawable.background_1),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Row {
                Image(
                    painterResource(R.drawable.girl_2),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(150.dp)
                )
                Column(Modifier.padding(horizontal = 10.dp, vertical = 20.dp),
                    verticalArrangement = Arrangement.Center,
                    ) {
                    state.workoutProgress?.data?.section_1?.plan_name?.let {
                        Text(text = it,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,modifier = Modifier.padding())
                    }
                    state.workoutProgress?.data?.section_1?.let {
                        Text(text = it.progress,
                            fontSize = 20.sp)
                    }
                    Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(0.dp)) {
                        Text(text = "CONTINUE")
                    }
                }
            }
        }
    }
}

