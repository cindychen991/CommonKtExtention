package com.cindy.lib.ktx

import android.text.TextUtils
import com.cindy.lib.internal.InlineOnly

fun String?.isEmptyOrNull(): Boolean = TextUtils.isEmpty(this)

@InlineOnly
inline fun String?.doIfEmpty(ifDo: () -> Unit) =
    if (this.isEmptyOrNull()) {
        ifDo.invoke()
    } else {
        // no-op
    }

@InlineOnly
inline fun String?.doIfEmptyOrNot(ifDo: () -> Unit, ifNot: (String) -> Unit) =
    if (this.isEmptyOrNull()) {
        ifDo.invoke()
    } else {
        ifNot.invoke(this!!)
    }

