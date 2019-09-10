package com.cindy.lib.internal

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.DisplayMetrics
import android.view.WindowManager

object UIUtil {
    private val MAIN_HANDLER = Handler(Looper.getMainLooper())

    var displayMetrics: DisplayMetrics? = null
        private set

    val density: Float
        get() = displayMetrics?.density ?: 0F

    val screenWidth: Int
        get() = displayMetrics?.widthPixels ?: 0

    val screenHeight: Int
        get() = displayMetrics?.heightPixels ?: 0

    /**
     * 初始化
     */
    fun init(context: Context) {
        if (displayMetrics != null) {
            return
        }
        displayMetrics = DisplayMetrics()
        val mWindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        mWindowManager.defaultDisplay.getMetrics(displayMetrics)
    }

    fun dp2px(dpValue: Float): Int {
        val scale = density
        return (dpValue * scale + 0.5f).toInt()
    }

}
