package com.github.chenqimiao.aop.feature.pointcut;

import com.github.chenqimiao.aop.overview.EchoService;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-01-27 14:34
 **/
public class EchoServiceStaticMethodMatcherPointcut implements Pointcut {
	public static final EchoServiceStaticMethodMatcherPointcut INSTANCE = new EchoServiceStaticMethodMatcherPointcut();

	private EchoServiceStaticMethodMatcherPointcut() {

	}

	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			@Override
			public boolean matches(Class<?> clazz) {
				return EchoService.class.isAssignableFrom(clazz);
			}
		};
	}

	@Override
	public MethodMatcher getMethodMatcher() {
		return new StaticMethodMatcher() {
			@Override
			public boolean matches(Method method, Class<?> targetClass) {
				return Objects.equals("echo", method.getName())
						&& method.getParameterCount() == 1
						&& Objects.equals(method.getParameterTypes()[0], String.class);
			}
		};
	}
}
