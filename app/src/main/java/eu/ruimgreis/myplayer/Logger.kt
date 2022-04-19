package eu.ruimgreis.myplayer

import android.util.Log

interface Logger {
    val tag: String
        get() = javaClass.name

    fun d(message: String) {
        Log.d(tag, message)
    }

    fun e(message: String) {
        Log.e(tag, message)
    }
}