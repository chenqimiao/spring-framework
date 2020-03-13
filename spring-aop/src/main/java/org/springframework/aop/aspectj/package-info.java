/**
 * AspectJ integration package. Includes Spring AOP advice implementations for AspectJ 5
 * annotation-style methods, and an AspectJExpressionPointcut: a Spring AOP Pointcut
 * implementation that allows use of the AspectJ pointcut expression language with the Spring AOP
 * runtime framework.
 *
 * <p>Note that use of this package does <i>not</i> require the use of the {@code ajc} compiler
 * or AspectJ load-time weaver. It is intended to enable the use of a valuable subset of AspectJ
 * functionality, with consistent semantics, with the proxy-based Spring AOP framework.
 *
 * Spring 实现了一套Aspectj style的AOP操作,
 * 这套操作本质上来说不是Aspectj，仅仅用到了Aspectj的注解语法，在实现层面还是Spring自己搞的.
 * 与Spring 原生API相比, Aspectj在使用上确实方便很多.
 * 具体实现上来说，原生API实现和AspectJ style适配层复用了一套接口定义
 *
 */
@NonNullApi
@NonNullFields
package org.springframework.aop.aspectj;

import org.springframework.lang.NonNullApi;
import org.springframework.lang.NonNullFields;
