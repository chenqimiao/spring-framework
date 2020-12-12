package com.github.chenqimiao.aop.overview;

import org.springframework.cglib.core.ReflectUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @Description: 过滤器（如何筛选 Join point）
 * @Author: Qimiao Chen
 * @Create: 2020-12-12 17:45
 **/
public class TargetFilterDemo {
	public static void main(String[] args) throws ClassNotFoundException {
		String targetClassName = "com.github.chenqimiao.aop.overview.EchoService";
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Class<?> targetClass = classLoader.loadClass(targetClassName);

		ReflectionUtils.doWithMethods(targetClass, new ReflectionUtils.MethodCallback() {
			@Override
			public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
				System.out.println("仅声明可能抛出的异常为 "
						+ NullPointerException.class.getSimpleName() + "的方法为 "
						+ method.getName());
			}
		}, new ReflectionUtils.MethodFilter() {
			@Override
			public boolean matches(Method method) {
				Class<?>[] exceptionTypes = method.getExceptionTypes();
				return exceptionTypes.length == 1
						&& exceptionTypes[0].equals(NullPointerException.class);
			}
		});
	}
}
