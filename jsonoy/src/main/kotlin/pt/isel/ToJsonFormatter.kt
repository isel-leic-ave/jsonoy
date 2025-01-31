package pt.isel

import kotlin.reflect.KClass

@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class ToJsonFormatter(
    val formatter: KClass<out ToJsonValueFormatter>,
)
