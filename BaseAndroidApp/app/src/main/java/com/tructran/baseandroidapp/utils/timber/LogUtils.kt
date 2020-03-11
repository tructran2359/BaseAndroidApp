package com.tructran.baseandroidapp.utils.timber

import timber.log.Timber

fun String.formatTag() = "${TimberDebugTree.TAG_PREFIX}$this"

fun Any.logI(tag: String, message: String) { Timber.i("${tag.formatTag()} $message") }
fun Any.logW(tag: String, message: String) { Timber.w("${tag.formatTag()} $message") }
fun Any.logD(tag: String, message: String) { Timber.d("${tag.formatTag()} $message") }
fun Any.logE(tag: String, message: String) { Timber.e("${tag.formatTag()} $message") }

fun Any.logThrowable(tag: String, throwable: Throwable) {
    logE(tag, throwable.message ?: throwable.toString())
    Timber.e(throwable)
}