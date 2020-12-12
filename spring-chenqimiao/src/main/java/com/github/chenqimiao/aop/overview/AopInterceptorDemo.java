package com.github.chenqimiao.aop.overview;

import com.github.chenqimiao.aop.overview.interceptor.AfterReturnInterceptor;
import com.github.chenqimiao.aop.overview.interceptor.BeforeInterceptor;
import com.github.chenqimiao.aop.overview.interceptor.ExceptionInterceptor;
import com.github.chenqimiao.aop.overview.interceptor.FinallyInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: Aop 拦截器示例
 * @Author: Qimiao Chen
 * @Create: 2020-12-12 17:58
 **/
public class AopInterceptorDemo {

	public static void main(String[] args) {
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		final EchoService defaultEchoService = new DefaultEchoService();
		EchoService echoService = (EchoService) Proxy.newProxyInstance(contextClassLoader, new Class<?>[]{EchoService.class}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				final long startTime[] = {0L}, endTime[] = {0L};
				Object result = null;
				try {
					BeforeInterceptor beforeInterceptor = new BeforeInterceptor() {
						@Override
						public Object before(Object proxy, Method method, Object[] args) {
							long startTime = System.currentTimeMillis();
							System.out.println("执行方法[" + method.getName() + "]的开始时间: " + startTime);
							return startTime;
						}
					};
					startTime[0] = (long)beforeInterceptor.before(proxy, method, args);
					if (EchoService.class.isAssignableFrom(method.getDeclaringClass())
							&& method.getName().equals("echo")
							&& method.getParameterCount() == 1
							&& method.getParameterTypes()[0].equals(String.class)) {

						result = defaultEchoService.echo("Promote" + (String)args[0]);

					}

					AfterReturnInterceptor afterReturnInterceptor = new AfterReturnInterceptor() {
						@Override
						public Object after(Object proxy, Method method, Object[] args, Object returnVal) {
							long endTime = System.currentTimeMillis();
							System.out.println("执行方法[" + method.getName() + "]的结束时间: " + endTime);
							return endTime;
						}
					};

					endTime[0] = (long)afterReturnInterceptor.after(proxy, method, args, result);

				}catch (Exception e) {

					ExceptionInterceptor exceptionInterceptor = new ExceptionInterceptor() {
						@Override
						public Object intercept(Object proxy, Method method, Object[] args, Throwable throwable) {
							System.out.println("执行方法[" + method.getName() + "]发生异常: " + throwable.getMessage());
							return new Object();
						}
					};
					exceptionInterceptor.intercept(proxy, method, args, e);
				}finally {
					FinallyInterceptor finallyInterceptor = new FinallyInterceptor() {
						@Override
						public Object finalize(Object proxy, Method method, Object[] args, Object returnVal) {
							System.out.println("执行方法[" + method.getName() + "]耗时: " +  (endTime[0] - startTime[0]) + " ms.");
							return returnVal;
						}
					};
					result = finallyInterceptor.finalize(proxy, method, args, result);

				}
				return result;

			}


		});

		// 执行..
		echoService.echo("Hello, Qimiao Chen");
	}
}
