@file:Suppress("NOTHING_TO_INLINE")

package com.cindy.lib.ktx

import android.view.View
import com.cindy.lib.internal.InlineOnly
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * if (view.isInvisible) {
 *     // Do sth...
 * }
 * view.isInvisible = true
 */
@InlineOnly
inline var View.isInvisible: Boolean
    get() = visibility == View.INVISIBLE
    set(value) {
        visibility = if (value) View.INVISIBLE else View.VISIBLE
    }
@InlineOnly
inline var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

@InlineOnly
inline var View.isGone: Boolean
    get() = visibility == View.GONE
    set(value) {
        visibility = if (value) View.GONE else View.VISIBLE
    }
@InlineOnly
inline fun View.setPadding(size: Int) {
    setPadding(size, size, size, size)
}


fun View.autoDisposeClick(
    context: CoroutineContext = Dispatchers.Main,
    handler: suspend CoroutineScope.(v: View?) -> Unit
) {
    setOnClickListener { v ->
        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
            handler(v)
        }.autoDispose(v)
    }
}