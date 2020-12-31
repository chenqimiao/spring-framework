package com.github.chenqimiao.aop.feature;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: AspectJApiDemo
 * @Author: Qimiao Chen
 * @Create: 2020-12-31 14:30
 **/

public class AspectJAPIDemo {

	public static void main(String[] args) {
		Map<String, Object> cache = new HashMap<>();

		AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(cache);

		aspectJProxyFactory.addAdvice(new MethodBeforeAdvice() {
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				if ("put".equals(method.getName()) && args.length == 2) {
					System.out.printf("%s 方法被增强", method.getName());
				}
			}
		});

		Map<String, Object> proxy = aspectJProxyFactory.getProxy();

		proxy.put("name", "Qimiao Chen");

		proxy.get("name");

	}
}
