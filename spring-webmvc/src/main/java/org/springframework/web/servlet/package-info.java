/**
 * Provides servlets that integrate with the application context
 * infrastructure, and the core interfaces and classes for the
 * Spring web MVC framework.
 *
 * <p>This package and related packages are discussed in Chapters 12 and 13 of
 * <a href="https://www.amazon.com/exec/obidos/tg/detail/-/0764543857/">Expert One-On-One J2EE Design and Development</a>
 * by Rod Johnson (Wrox, 2002).
 *
 *
 * Servlet container -> DispatcherServlet -> Search handler -> Search interceptor -> 封装成chain
 * -> 执行interceptor preHandler -> Handler 参数解析（转化）-> 反射调用handler方法
 * -> 返回结果处理（对于标注了@ResponseBody的方法的返回结果直接写入到response的输出流）
 * -> 执行interceptor postHandler(可能会往HTTP response输出流写入东西)
 * -> 如果有需要,进行视图渲染,写入到HTTP response 输出流
 * -> 执行interceptor afterCompletion（常用于资源清理）
 * -> 完成一次HTTP请求
 */
@NonNullApi
@NonNullFields
package org.springframework.web.servlet;

import org.springframework.lang.NonNullApi;
import org.springframework.lang.NonNullFields;
