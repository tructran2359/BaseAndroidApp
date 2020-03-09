package com.tructran.baseandroidapp.presentation.base

import androidx.lifecycle.ViewModel
import com.tructran.baseandroidapp.presentation.home.HomeViewModel
import javax.inject.Provider

/**
 * Place holder for Dependencies Injection
 * Should use Dagger or some similar lib to do it
 */
class AppInjector {
    companion object {
        fun providesViewModelMap(): Map<Class<out ViewModel>, Provider<ViewModel>> {
            return mapOf(
                HomeViewModel::class.java to Provider<ViewModel> { HomeViewModel() }
            )
        }

        fun providesViewModelFactory(): AppViewModelFactory {
            return AppViewModelFactory(providesViewModelMap())
        }
    }
}