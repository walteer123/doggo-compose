package com.walter.doggo_compose.navigation.domain.command

import androidx.navigation.compose.NamedNavArgument

interface NavigationCommand {
    val arguments: List<NamedNavArgument>
    val destination: String
}
