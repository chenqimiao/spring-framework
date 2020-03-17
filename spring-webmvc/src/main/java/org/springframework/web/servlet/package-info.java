/**
 * Provides servlets that integrate with the application context
 * infrastructure, and the core interfaces and classes for the
 * Spring web MVC framework.
 *
 * <p>This package and related packages are discussed in Chapters 12 and 13 of
 * <a href="https://www.amazon.com/exec/obidos/tg/detail/-/0764543857/">Expert One-On-One J2EE Design and Development</a>
 * by Rod Johnson (Wrox, 2002).
 *
 * MVC大致启动流程（仅针对注解的形式，接口形式注册Handler会有一些出入）
 * Servlet3.0 SPI -> Spring扫描整个项目 -> 拿到所有的Handler类(如被@Controller注解的类) -> 遍历类里面的方法
 * -> 判断方法是否加了@RequestMapping注解 -> 将@RequestMapping的value作为key,对应方法作为value，存储到一个Map缓存供后续查询
 *
 *
 *
 * 请求处理流程
 * Servlet container -> DispatcherServlet -> Search handler -> Search interceptor -> 封装成chain
 * -> 执行interceptor preHandler -> Handler 参数解析（转化）-> 反射调用handler方法
 * -> 返回结果处理（对于标注了@ResponseBody的方法的返回结果直接写入到response的输出流）
 * -> 执行interceptor postHandler(可能会往HTTP response输出流写入东西)
 * -> 如果有需要,进行视图渲染,写入到HTTP response 输出流
 * -> 执行interceptor afterCompletion（常用于资源清理）
 * -> 完成一次HTTP请求
 *
 *
 *
 * MVC启动过程中resolver、Handler、HandlerAdapter的注册顺序
 *
 * \@EnableWebMvc的元注解@Import -> 注册各种Handler/HandlerAdapter Bean
 * -> 回调RequestMappingHandlerAdapter#afterPropertiesSet完成参数解析器的初始化
 *  （以HandlerMethodArgumentResolverComposite的封装形式作为上述Adapter的成员变量，未直接作为Bean注册到容器中）
 * -> Servlet#init -> DispatcherServlet#initStrategies
 * -> 将容器中的注册的Handler、HandlerAdapter拿出来以集合的形式缓存到DispatcherServlet中去
 *
 * 以上流程忽略了一些细节
 */
@NonNullApi
@NonNullFields
package org.springframework.web.servlet;

import org.springframework.lang.NonNullApi;
import org.springframework.lang.NonNullFields;
