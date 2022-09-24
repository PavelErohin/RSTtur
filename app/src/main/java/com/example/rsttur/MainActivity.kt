package com.example.rsttur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rsttur.screens.main.MainScreen
import com.example.rsttur.ui.theme.MainTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MainTheme(darkTheme = isSystemInDarkTheme()) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {

          val bottomItems = listOf("Главная", "Карта", "Бронь", "Чат", "Ещё")

          val navController = rememberNavController()

          Scaffold(bottomBar = {
            BottomNavigation {
              bottomItems.forEach { screen ->
                BottomNavigationItem(
                  selected = false,
                  onClick = { navController.navigate(screen) },
                  label = { Text(screen) },
                  icon = {}) //todo icon
              }
            }
          }) {
            NavHost(navController = navController, startDestination = "Главная") {
              composable("Главная") { MainScreen() }
              composable("Карта") { Text("Карта") }
              composable("Бронь") { Text("Бронь") }
              composable("Чат") { Text("Чат") }
              composable("Ещё") { Text("Ещё") }
            }
          }
        }
      }
    }
  }
}