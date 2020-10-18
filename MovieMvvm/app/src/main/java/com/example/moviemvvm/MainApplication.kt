package com.example.moviemvvm

import android.app.Application
import com.example.moviemvvm.di.networkModule
import com.example.moviemvvm.di.repositoryModule
import com.example.moviemvvm.di.sharedPrefModule
import com.example.moviemvvm.di.viewModelModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            koin.loadModules(listOf(repositoryModule,networkModule, sharedPrefModule, viewModelModule))

//            modules(viewModelModule, repositoryModule, networkModule, sharedPrefModule)
        }
    }
}