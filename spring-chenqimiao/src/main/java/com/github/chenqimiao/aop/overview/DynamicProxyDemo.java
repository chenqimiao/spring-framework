package com.github.chenqimiao.aop.overview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: 动态代理示例
 * @Author: Qimiao Chen
 * @Create: 2020-12-12 17:31
 **/
public class DynamicProxyDemo {
	public static void main(String[] args) {
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		final EchoService defaultEchoService = new DefaultEchoService();
		EchoService echoService = (EchoService)Proxy.newProxyInstance(contextClassLoader, new Class<?>[]{EchoService.class}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if (EchoService.class.isAssignableFrom(method.getDeclaringClass())
						&& method.getName().equals("echo")
						&& method.getParameterCount() == 1
						&& method.getParameterTypes()[0].equals(String.class)) {
					// 拦截 echo 方法 进行提升
					long startTime = System.currentTimeMillis();
					String result = defaultEchoService.echo((String)args[0]);
					long costTime = System.currentTimeMillis() - startTime;
					System.out.println("执行 echo 方法需要 " + costTime + " ms.");
					return result;
				}
				return method.invoke(proxy);
			}
		});
		echoService.echo("Hello, Qimiao Chen");
	}
}
