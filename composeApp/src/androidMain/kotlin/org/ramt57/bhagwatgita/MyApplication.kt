package org.ramt57.bhagwatgita

import android.app.Application
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext
import org.ramt57.bhagwatgita.di.initKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MyApplication)
        }
    }
}