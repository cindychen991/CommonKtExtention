package com.cindy.lib.ktx

import com.cindy.lib.internal.InlineOnly


@InlineOnly
inline fun <T> T.doIf(condition: () -> Boolean?, ifDoBlock: T.() -> Unit): T {
    if (condition.invoke() == true) {
        this.apply(ifDoBlock)
    }
    return this
}


@InlineOnly
inline fun <T> T.doIf(condition: () -> Boolean?, ifDo: T.() -> Unit, ifNot: T.() -> Unit): T {
    if (condition.invoke() == true) {
        this.apply(ifDo)
    } else {
        this.apply(ifNot)
    }
    return this
}

@InlineOnly
inline fun <T> T.doIfNot(condition: () -> Boolean?, ifNotBlock: T.() -> Unit): T {
    if (condition.invoke() != true) {
        this.apply(ifNotBlock)
    }
    return this
}


@InlineOnly
inline fun <T> T?.doIfNull(ifDoBlock: () -> Unit) {
    if (this == null) {
        ifDoBlock()
    }
}

@InlineOnly
inline fun <T> T?.doIfNull(ifDo: () -> Unit, ifNot: (T) -> Unit) {
    if (this == null) {
        ifDo()
    } else {
        ifNot(this)
    }
}