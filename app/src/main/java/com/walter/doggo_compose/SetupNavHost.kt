package com.walter.doggo_compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.walter.doggo_compose.breed.presentation.Breed
import com.walter.doggo_compose.navigation.domain.directions.NavigationDirections
import com.walter.doggo_compose.navigation.domain.manager.NavigationManagerImpl
import org.koin.androidx.compose.get

@Composable
fun SetupNavHost() {
    val navController = rememberNavController()
    NavHostBuilder(navController)
}

@Composable
private fun NavHostBuilder(navController: NavHostController, manager: NavigationManagerImpl = get()) {
    NavHost(
        navController = navController,
        startDestination = NavigationDirections.breeds.destination
    ) {
        composable(NavigationDirections.breeds.destination) {
            Breed()
        }
    }

    manager.get().collectAsState().value?.also { command ->
        if (command.destination.isNotEmpty()) {
            navController.navigate(command.destination)
        }
    }
}
