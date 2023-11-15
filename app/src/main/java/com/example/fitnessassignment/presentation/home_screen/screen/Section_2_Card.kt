package com.example.fitnessassignment.presentation.home_screen.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fitnessassignment.R
import com.example.fitnessassignment.data.remote.dto.Section2
import com.example.fitnessassignment.presentation.home_screen.state.MainViewState
import com.example.fitnessassignment.ui.theme.light_green
import com.example.fitnessassignment.ui.theme.sky


@Composable
fun Section_2_Card(state: MainViewState){
    state.workoutProgress?.data?.let { GradientCard(it.section_2) }

}


@Composable
fun GradientCard(section2: Section2) {
    // Define the gradient colors
    val gradientColors = listOf(
        sky,
        light_green
    )

    // Create a Brush using the gradient colors
    val gradientBrush = Brush.verticalGradient(gradientColors)

    // Use the Card component with a gradient background
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.Transparent),
    ) {
        // Use a Box to apply the gradient background
        Box(
            modifier = Modifier
                .background(brush = gradientBrush)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                item {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = null, // Provide a description for accessibility
                            modifier = Modifier
                                .size(90.dp)
                                .clip(CircleShape)// Set the size of the image
                                .padding(16.dp), // Add padding if needed
                            contentScale = ContentScale.Crop // Adjust content scale as needed
                        )
                        Column {
                            Text(text = "Accuracy", color = Color.White)
                            Text(text = section2.accuracy, color = Color.White)
                        }
                    }
                }
                item {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = null, // Provide a description for accessibility
                            modifier = Modifier
                                .size(90.dp)
                                .clip(CircleShape)// Set the size of the image
                                .padding(16.dp), // Add padding if needed
                            contentScale = ContentScale.Crop // Adjust content scale as needed
                        )
                        Column {
                            Text(text = "Workout Duration", color = Color.White)
                            Text(text = section2.workout_duration, color = Color.White)
                        }
                    }
                }

                item {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = null, // Provide a description for accessibility
                            modifier = Modifier
                                .size(90.dp)
                                .clip(CircleShape)// Set the size of the image
                                .padding(16.dp), // Add padding if needed
                            contentScale = ContentScale.Crop // Adjust content scale as needed
                        )
                        Column {
                            Text(text = "Reps", color = Color.White)
                            Text(text = section2.reps.toString(), color = Color.White)
                        }
                    }
                }
                item {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = null, // Provide a description for accessibility
                            modifier = Modifier
                                .size(90.dp)
                                .clip(CircleShape)// Set the size of the image
                                .padding(16.dp), // Add padding if needed
                            contentScale = ContentScale.Crop // Adjust content scale as needed
                        )
                        Column {
                            Text(text = "Calories Burn", color = Color.White)
                            Text(text = section2.calories_burned.toString(), color = Color.White)
                        }
                    }

                }


            }
        }
    }
}