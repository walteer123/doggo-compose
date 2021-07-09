package com.walter.doggo_compose

import android.app.Application
import com.walter.doggo.network.di.injectNetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin { androidContext(this@MyApplication) }
        injectNetworkModule()
    }
}
