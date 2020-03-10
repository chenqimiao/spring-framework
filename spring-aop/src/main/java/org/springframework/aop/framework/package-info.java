/**
 * Package containing Spring's basic AOP infrastructure, compliant with the
 * <a href="http://aopalliance.sourceforge.net">AOP Alliance</a> interfaces.
 *
 * <p>Spring AOP supports proxying interfaces or classes, introductions, and offers
 * static and dynamic pointcuts.
 *
 * <p>Any Spring AOP proxy can be cast to the ProxyConfig AOP configuration interface
 * in this package to add or remove interceptors.
 *
 * <p>The ProxyFactoryBean is a convenient way to create AOP proxies in a BeanFactory
 * or ApplicationContext. However, proxies can be created programmatically using the
 * ProxyFactory class.
 *
 *
 * 这里梳理AOP API层面几个概念
 * Advice 增强建议
 * Advisor 顾问，我这里把它理解成发起建议的人，包含Advice和Filter(常常指PointCut)
 * Advised 被增强的对象，被ProxyObject实现,可以获取一些信息
 * {@link org.aopalliance.intercept.Interceptor} 拦截器，底层实现上来说，Advice也会被适配包装成Interceptor，再进行传递、执行
 */
@NonNullApi
@NonNullFields
package org.springframework.aop.framework;

import org.springframework.lang.NonNullApi;
import org.springframework.lang.NonNullFields;
