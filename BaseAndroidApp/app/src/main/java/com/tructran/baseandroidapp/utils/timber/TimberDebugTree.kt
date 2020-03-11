package com.tructran.baseandroidapp.utils.timber

import timber.log.Timber

class TimberDebugTree : Timber.DebugTree() {

    companion object {
        const val TAG_PREFIX = "BAA_"
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        super.log(priority, (tag ?: "").formatTag() , message, t)
    }
}