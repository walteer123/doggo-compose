package com.walter.doggo_compose.navigation.domain.manager

import com.walter.doggo_compose.navigation.domain.command.NavigationCommand
import com.walter.doggo_compose.navigation.domain.directions.NavigationDirections
import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManager {
    val commands = MutableStateFlow(NavigationDirections.breeds)

    fun navigate(
        directions: NavigationCommand
    ) {
        commands.value = directions
    }
}
