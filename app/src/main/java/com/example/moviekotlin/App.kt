package com.example.moviekotlin

import android.app.Application
import com.example.moviekotlin.utils.modules.networkModule
import com.example.moviekotlin.utils.modules.repositoryMovie
import com.example.moviekotlin.utils.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{androidContext(this@App)
        modules(viewModelModule, networkModule, repositoryMovie)}
    }

}