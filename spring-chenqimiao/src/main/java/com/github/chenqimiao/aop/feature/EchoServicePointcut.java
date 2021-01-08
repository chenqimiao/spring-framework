package com.github.chenqimiao.aop.feature;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Description: EchoService Pointcut
 * @Author: Qimiao Chen
 * @Create: 2021-01-08 11:16
 **/
public class EchoServicePointcut extends StaticMethodMatcherPointcut {

	private String methodName;

	private Class<?> targetClass;


	public EchoServicePointcut(String methodName, Class<?> targetClass) {
		this.methodName = methodName;
		this.targetClass = targetClass;
	}

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return Objects.equals(methodName, method.getName()) && this.targetClass.isAssignableFrom(targetClass);
	}
}
