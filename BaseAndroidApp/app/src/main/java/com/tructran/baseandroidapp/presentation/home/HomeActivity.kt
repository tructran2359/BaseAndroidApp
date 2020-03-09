package com.tructran.baseandroidapp.presentation.home

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.tructran.baseandroidapp.R
import com.tructran.baseandroidapp.presentation.base.BaseActivity
import com.tructran.baseandroidapp.utils.observeNonNull
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    private lateinit var mHomeVM: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        mHomeVM = getViewModel()

        Log.d("Test", "ViewModel: $mHomeVM")

        observe()

        mHomeVM.startCounting()
    }

    private fun observe() {
        mHomeVM.let { vm ->
            vm.liveCount.observeNonNull(this) { count ->
                tv_count.text = count.toString()
            }
        }
    }
}