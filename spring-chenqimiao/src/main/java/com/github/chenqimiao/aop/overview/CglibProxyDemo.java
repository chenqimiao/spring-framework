package com.github.chenqimiao.aop.overview;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description: Cglib 代理提升示例
 * @Author: Qimiao Chen
 * @Create: 2020-12-27 21:35
 **/
public class CglibProxyDemo {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		Class<?> superClass = DefaultEchoService.class;
		enhancer.setSuperclass(superClass);
		enhancer.setInterfaces(new Class<?>[]{EchoService.class});
		enhancer.setCallback(new MethodInterceptor(){

			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

				long startTime = System.currentTimeMillis();
				// 调用 proxy 父类方法
				Object result = methodProxy.invokeSuper(proxy, args);

				long endTime = System.currentTimeMillis();
				// 通过打印，可以发现 Cglib 提升对性能是有消耗的, 与 JDK dynamic 相比，性能略差一些, 但是适应性更强一些
				System.out.println("通过 Cglib 提升后, 方法耗时: " + (endTime - startTime) + "ms.");

				return result;
			}
		});

		EchoService echoService = (EchoService) enhancer.create();

		String result = echoService.echo("Hello, World");

		System.out.println(result);

	}

}
