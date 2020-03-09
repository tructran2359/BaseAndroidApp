package com.tructran.baseandroidapp.presentation.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity : AppCompatActivity() {

    /**
     * Should be injected by DI
     */
    var mVmFactory = AppInjector.providesViewModelFactory()

    inline fun <reified VM: BaseViewModel> getViewModel(): VM {
        val viewModel = ViewModelProvider(this, mVmFactory).get(VM::class.java)
        return viewModel
    }
}