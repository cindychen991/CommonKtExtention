package com.cindy.lib.ktx

import android.app.Activity
import android.view.inputmethod.InputMethodManager


fun Activity.hideSoftInput() =
    try {
        (getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(
                window.decorView
                    .windowToken, 0
            )
    } catch (e: Exception) {
        //no-op
    }