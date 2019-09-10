package com.cindy.lib.internal

import android.support.v4.view.ViewCompat
import android.view.View
import kotlinx.coroutines.Job

class AutoDisposableJob(private val view: View,
                        private val wrapJob: Job) : Job by wrapJob, View.OnAttachStateChangeListener {

    init {
        if (ViewCompat.isAttachedToWindow(view)) {
            view.addOnAttachStateChangeListener(this)
        } else {
            cancel()
        }
        invokeOnCompletion {
            view.removeOnAttachStateChangeListener(this)
        }
    }

    override fun onViewAttachedToWindow(v: View?) = Unit

    override fun onViewDetachedFromWindow(v: View?) {
        cancel()
        view.removeOnAttachStateChangeListener(this)
    }
}
