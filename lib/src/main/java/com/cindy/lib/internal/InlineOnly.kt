package com.cindy.lib.internal

@Target(
    AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY,
    AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER
)
@DslMarker
@Retention(AnnotationRetention.BINARY)
internal annotation class InlineOnly
