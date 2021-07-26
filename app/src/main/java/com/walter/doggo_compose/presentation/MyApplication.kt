package com.walter.doggo_compose.presentation

import android.app.Application
import com.walter.doggo.network.di.injectNetworkModule
import com.walter.doggo_compose.breed.presentation.di.injectBreedKoinModule
import com.walter.doggo_compose.navigation.di.injectNavigationKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin { androidContext(this@MyApplication) }
        injectNetworkModule()
        injectBreedKoinModule()
        injectNavigationKoinModule()
    }
}
