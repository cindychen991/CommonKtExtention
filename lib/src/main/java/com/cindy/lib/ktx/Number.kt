package com.cindy.lib.ktx

import com.cindy.lib.internal.InlineOnly
import com.cindy.lib.internal.UIUtil

/**
 * sample: val px = 4.dp2px
 *
 * //doSth
 *
 */
@InlineOnly
inline val Number.dp2px: Int
    get() = UIUtil.dp2px(this.toFloat())