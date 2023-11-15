@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.fitnessassignment.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.GroupWork
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Interests
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Contacts
import androidx.compose.material.icons.outlined.GroupWork
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.RemoveRedEye
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.fitnessassignment.R
import com.example.fitnessassignment.presentation.home_screen.MainViewModel
import com.example.fitnessassignment.presentation.home_screen.screen.HomeScreen
import com.example.fitnessassignment.ui.theme.FitnessAssignmentTheme
import com.example.fitnessassignment.ui.theme.primary
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

enum class Screen {
    Home, Progress, Performance, Option
}
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            FitnessAssignmentTheme {
                val mainViewModel: MainViewModel = hiltViewModel()
                val state by mainViewModel.mainViewState.collectAsState()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            BottomNavBar(navController)
                        },
                        topBar = {
                            TopAppBar(
                                title = {
                                    Column {
                                        Text(text = "Good Morning 🔥", fontSize = 15.sp, color = Color.Black)
                                        Text(text = "RIA", fontSize = 18.sp, color = Color.Black)
                                    }
                                },
                                actions = {
                                    IconButton(
                                        onClick = { startActivity(
                                            Intent(this@MainActivity,
                                            ProfileActivity::class.java)
                                        ) }) {
                                        AsyncImage(
                                            model = R.drawable.profile,
                                            contentDescription = "Profile image",
                                            modifier = Modifier
                                                .size(64.dp)
                                                .clip(CircleShape)
                                                .border(1.dp, Color.Black, CircleShape)
                                        )
                                    }
                                },
                                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White),
//                                scrollBehavior = scrollBehavior,
                            )
                        }
                    ) { paddingValues ->
                        NavHost(
                            navController = navController,
                            startDestination = Screen.Home.name,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues)
                        ) {
                            composable(Screen.Home.name) {
                                HomeScreen(state,mainViewModel::onRefreshScreen)
                            }
                            composable(Screen.Progress.name) { Text(text = "UNDER CONSTRUCTION PROGRESS") }
                            composable(Screen.Performance.name) { Text(text = "UNDER CONSTRUCTION PERFORMANCE") }
                            composable(Screen.Option.name) { Text(text = "UNDER CONSTRUCTION OPTION") }
                        }

                    }
                }
            }
        }
    }

    data class BottomNavigationItem(
        val title: String,
        val selectedIcon: ImageVector,
        val unselectedIcon: ImageVector,
        val hasNews: Boolean,
        val badgeCount: Int? = null
    )

    @Composable
    fun BottomNavBar(navController: NavHostController) {
        val items = listOf(
            BottomNavigationItem(
                title = Screen.Home.name,
                selectedIcon = Icons.Filled.RemoveRedEye,
                unselectedIcon = Icons.Outlined.RemoveRedEye,
                hasNews = false,
            ),
            BottomNavigationItem(
                title = Screen.Progress.name,
                selectedIcon = Icons.Filled.GroupWork,
                unselectedIcon = Icons.Outlined.GroupWork,
                hasNews = false,
                badgeCount = 45
            ),
            BottomNavigationItem(
                title = Screen.Performance.name,
                selectedIcon = Icons.Filled.Chat,
                unselectedIcon = Icons.Outlined.Chat,
                hasNews = true,
                badgeCount = 5
            ),
            BottomNavigationItem(
                title = Screen.Option.name,
                selectedIcon = Icons.Filled.Contacts,
                unselectedIcon = Icons.Outlined.Contacts,
                hasNews = true,
            ),
        )
        var selectedItemIndex by rememberSaveable {
            mutableStateOf(0)
        }
        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItemIndex == index,
                    onClick = {
                        selectedItemIndex = index
                        navController.navigate(item.title)
                    },
                    label = {
                        if(selectedItemIndex == index){
                            Text(text = item.title)
                        }
                    },
                    icon = {
                        BadgedBox(
                            badge = {
                                if(item.badgeCount != null) {
                                    Badge {
                                        Text(text = item.badgeCount.toString())
                                    }
                                } else if(item.hasNews) {
                                    Badge()
                                }
                            }
                        ) {
                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    item.selectedIcon
                                } else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        }
                    }
                )
            }
        }
    }

}
