package com.tructran.baseandroidapp.presentation.home

import android.os.Bundle
import com.tructran.baseandroidapp.R
import com.tructran.baseandroidapp.presentation.base.BaseActivity
import com.tructran.baseandroidapp.utils.observeNonNull
import com.tructran.baseandroidapp.utils.timber.logD
import com.tructran.baseandroidapp.utils.timber.logThrowable
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    private lateinit var mHomeVM: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        mHomeVM = getViewModel()

        logD("TestHome", "VM: $mHomeVM")

        try {
            exception1()
        } catch (e: Exception) {
            logThrowable("TestThrowable", e)
        }

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

    private fun exception1() {
        exception2()
    }

    private fun exception2() {
        val a: String? = null
        a!!.length
    }
}