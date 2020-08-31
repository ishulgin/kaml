package com.charleskorn.kaml

import kotlinx.serialization.SerialInfo
import kotlinx.serialization.modules.SerialModule
import kotlin.reflect.KClass

abstract class YamlCustomDecoder {
    abstract fun isApplicable(node: YamlNode): Boolean

    /**
     * Note that [YamlConfiguration.stringContentProcessor] should be applied manually if needed
     */
    abstract fun createDecoder(node: YamlNode, context: SerialModule, configuration: YamlConfiguration): YamlInput
}

@SerialInfo
@Target(AnnotationTarget.PROPERTY)
annotation class UseCustomYamlDecoder(val decoderClass: KClass<out YamlCustomDecoder>)
