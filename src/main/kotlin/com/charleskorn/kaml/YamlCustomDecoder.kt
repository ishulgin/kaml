package com.charleskorn.kaml

import kotlinx.serialization.SerialInfo
import kotlinx.serialization.modules.SerializersModule
import kotlin.reflect.KClass

public abstract class YamlCustomDecoder {
    public abstract fun isApplicable(node: YamlNode): Boolean

    /**
     * Note that [YamlConfiguration.stringContentProcessor] should be applied manually if needed
     */
    public abstract fun createDecoder(node: YamlNode, context: SerializersModule, configuration: YamlConfiguration): YamlInput
}

@SerialInfo
@Target(AnnotationTarget.PROPERTY)
public annotation class UseCustomYamlDecoder(val decoderClass: KClass<out YamlCustomDecoder>)
