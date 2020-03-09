package com.tructran.baseandroidapp.utils

import androidx.lifecycle.*
import com.tructran.baseandroidapp.presentation.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

inline fun <reified T: Any> LiveData<T>.observeNonNull(
    lifecycleOwner: LifecycleOwner,
    crossinline action: (T) -> Unit
) {
    this.observe(lifecycleOwner, Observer {
        it?.let(action)
    })
}

fun ViewModel.launchDefault(action: suspend () -> Unit) {
    viewModelScope.launch {
        action.invoke()
    }
}

fun ViewModel.launchWithIO(action: suspend () -> Unit) {
    viewModelScope.launch(Dispatchers.IO) {
        action.invoke()
    }
}