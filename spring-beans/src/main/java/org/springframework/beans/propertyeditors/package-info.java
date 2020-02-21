/**
 * Properties editors used to convert from String values to object
 * types such as java.util.Properties.
 *
 * <p>Some of these editors are registered automatically by BeanWrapperImpl.
 * "CustomXxxEditor" classes are intended for manual registration in
 * specific binding processes, as they are localized or the like.
 */
@NonNullApi
@NonNullFields
package org.springframework.beans.propertyeditors;

import org.springframework.lang.NonNullApi;
import org.springframework.lang.NonNullFields;

/**
 *
 * PropertyEditor vs Converter vs Formatter
 *
 * PropertyEditor 是java 定义的bean标准属性编辑器，source type 必须是 String, 使用场景不限制在Spring容器
 *
 * Converter 是Spring定义的在Spring容器中使用的转化器，依赖于ConversionService的注册，可以自由定义source 和 target 的类型
 *
 * Formatter 是为了满足在典型的客户端环境下（web/desktop应用）的类型转化需求而引入的，支持source <-> target的双向转化，source 类型必须是String,
 * 但是在Spring Mvc中，只用到了输入方向的转化即`String source -> any type target`
 *
 */
