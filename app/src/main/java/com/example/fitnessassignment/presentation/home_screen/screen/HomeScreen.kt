package com.example.fitnessassignment.presentation.home_screen.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitnessassignment.presentation.home_screen.state.MainViewState
import com.example.fitnessassignment.ui.theme.primary

@Composable
fun HomeScreen(
    state: MainViewState,
    onRefreshScreen: () -> Unit
){
    Column {
        CustomSearchBox(
            leadingIcon = {
                Icon(imageVector = Icons.Outlined.CameraAlt, contentDescription = "camera")
            },
            trailingIcon = {
                Icon(imageVector = Icons.Outlined.Search, contentDescription = "search")
            },
            modifier = Modifier
                .background(
                    Color.White,
                    RoundedCornerShape(percent = 50)
                )
                .padding(start = 20.dp, end = 20.dp)
                .height(40.dp),
            fontSize = 14.sp,
        )

        state.workoutProgress?.let {
            Text(text = it.message)
        }
        Section_1_Card(state)
        Section_2_Card(state)

    }
}

@Composable
private fun CustomSearchBox(
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    placeholderText: String = "Search Exercise",
    fontSize: TextUnit = 14.sp,
) {
    var text by rememberSaveable { mutableStateOf("") }
    BasicTextField(modifier = modifier
        .background(
            Color.Black,
            MaterialTheme.shapes.large,
        )
        .fillMaxWidth()
        .padding(1.dp),
        value = text,
        onValueChange = {
            text = it
        },
        singleLine = true,
        cursorBrush = SolidColor(primary),
        textStyle = LocalTextStyle.current.copy(
            color = Color.Black,
            fontSize = fontSize
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) leadingIcon()
                Box(Modifier.weight(1f)) {
                    if (text.isEmpty()) Text(
                        placeholderText,
                        style = LocalTextStyle.current.copy(
                            color = Color.Gray,
                            fontSize = fontSize
                        )
                    )
                    innerTextField()
                }
                if (trailingIcon != null) trailingIcon()
            }
        }
    )
}