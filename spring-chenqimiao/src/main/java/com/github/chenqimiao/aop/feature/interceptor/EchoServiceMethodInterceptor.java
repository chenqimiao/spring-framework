package com.github.chenqimiao.aop.feature.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-01-14 16:20
 **/
public class EchoServiceMethodInterceptor implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Method method = invocation.getMethod();
		System.out.println("拦截 EchoService 的方法：" + method);
		return invocation.proceed();
	}
}
