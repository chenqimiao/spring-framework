package com.github.chenqimiao.aop.feature;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-12-31 15:08
 **/
public class AspectJAnnotatedAPIDemo {
	public static void main(String[] args) {

		AspectJAnnotatedAPIDemo aspectJAnnotatedAPIDemo = new AspectJAnnotatedAPIDemo();

		AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(aspectJAnnotatedAPIDemo);

		aspectJProxyFactory.addAspect(AspectJConfiguration.class);

		aspectJProxyFactory.addAdvice(new MethodBeforeAdvice() {
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println(method.getName() + " 方法被增强!");
			}
		});
		AspectJAnnotatedAPIDemo proxy = aspectJProxyFactory.getProxy();

		proxy.execute();

	}

	public void execute(){
		System.out.println("execute() ...");
	}
}
