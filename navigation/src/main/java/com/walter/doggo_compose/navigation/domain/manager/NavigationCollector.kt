package com.walter.doggo_compose.navigation.domain.manager

import com.walter.doggo_compose.navigation.domain.command.NavigationCommand
import kotlinx.coroutines.flow.MutableStateFlow

interface NavigationCollector {
    fun get(): MutableStateFlow<NavigationCommand?>
}
