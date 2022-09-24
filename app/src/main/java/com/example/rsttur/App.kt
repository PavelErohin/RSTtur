package com.example.rsttur

import android.app.Application
import com.example.rsttur.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class App : Application() {
  override fun onCreate() {
    super.onCreate()
    // Start Koin
    GlobalContext.startKoin {
      androidLogger()
      androidContext(this@App)
      modules(appModule)
    }
  }
}