package com.tructran.baseandroidapp.presentation.application

import android.app.Application
import com.tructran.baseandroidapp.BuildConfig
import com.tructran.baseandroidapp.utils.timber.TimberDebugTree
import timber.log.Timber

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(TimberDebugTree())
        }
    }
}