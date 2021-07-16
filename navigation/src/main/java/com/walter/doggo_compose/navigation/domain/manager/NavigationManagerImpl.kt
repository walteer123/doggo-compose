package com.walter.doggo_compose.navigation.domain.manager

import com.walter.doggo_compose.navigation.domain.command.NavigationCommand
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.withContext

class NavigationManagerImpl : NavigationManager, NavigationCollector {
    private val commands: MutableStateFlow<NavigationCommand?> = MutableStateFlow(null)

    override fun navigate(directions: NavigationCommand) {
        commands.value = directions
    }

    override fun get(): MutableStateFlow<NavigationCommand?> = commands

}
