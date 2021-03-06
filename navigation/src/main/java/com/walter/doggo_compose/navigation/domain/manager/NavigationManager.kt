package com.walter.doggo_compose.navigation.domain.manager

import com.walter.doggo_compose.navigation.domain.command.NavigationCommand

interface NavigationManager {
    fun navigate(directions: NavigationCommand)
}
