package com.walter.doggo_compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.walter.doggo_compose.breed.presentation.Breed
import com.walter.doggo_compose.navigation.domain.directions.NavigationDirections
import com.walter.doggo_compose.navigation.domain.manager.NavigationManagerImpl
import com.walter.doggo_compose.presentation.theme.DoggoTheme
import org.koin.androidx.compose.get

@Composable
fun AppRouter() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationDirections.breeds.destination
    ) {
        composable(NavigationDirections.breeds.destination) {
            Breed()
        }
    }
    NavigationManager(navController)
}

@Composable
private fun NavigationManager(navController: NavHostController, manager: NavigationManagerImpl = get()) {
    manager.get().collectAsState().value?.also { command ->
        if (command.destination.isNotEmpty()) {
            navController.navigate(command.destination)
        }
    }
}

@Preview
@Composable
private fun PreviewTheme(){
    DoggoTheme(darkTheme = true) {
        Column {
            Text(text = "Teestando")
            Button(onClick = { }) {
                Text(text = "123")
            }
        }
    }
}
