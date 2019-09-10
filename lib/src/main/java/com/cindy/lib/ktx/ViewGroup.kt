@file:Suppress("NOTHING_TO_INLINE")

package com.cindy.lib.ktx

import android.view.View
import android.view.ViewGroup
import com.cindy.lib.internal.InlineOnly

@InlineOnly
inline operator fun ViewGroup.get(index: Int) =
        getChildAt(index) ?: throw IndexOutOfBoundsException("Index: $index, Size: $childCount")

@InlineOnly
inline operator fun ViewGroup.contains(view: View) = indexOfChild(view) != -1

@InlineOnly
inline fun ViewGroup.isEmpty() = childCount == 0

