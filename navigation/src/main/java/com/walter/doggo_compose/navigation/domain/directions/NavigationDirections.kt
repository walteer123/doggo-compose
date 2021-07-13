package com.walter.doggo_compose.navigation.domain.directions

import androidx.navigation.compose.NamedNavArgument
import com.walter.doggo_compose.navigation.domain.command.NavigationCommand

object NavigationDirections {
    val breeds = object : NavigationCommand {
        override val arguments: List<NamedNavArgument> = emptyList()

        override val destination: String = "breeds"

    }
}
