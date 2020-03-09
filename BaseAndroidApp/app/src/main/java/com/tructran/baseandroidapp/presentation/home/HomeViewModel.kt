package com.tructran.baseandroidapp.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tructran.baseandroidapp.presentation.base.BaseViewModel
import com.tructran.baseandroidapp.utils.launchWithIO
import kotlinx.coroutines.delay

/**
 * Constructor should be injected using dependencies injection
 */
class HomeViewModel : BaseViewModel() {

    private val _liveCount: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val liveCount: LiveData<Int>
        get() = _liveCount

    fun startCounting() {
        launchWithIO {
            var count = 0
            repeat(10) {
                count++
                _liveCount.postValue(count)
                Log.d("Test", "Count: $count")
                delay(1000)
            }
        }
    }
}