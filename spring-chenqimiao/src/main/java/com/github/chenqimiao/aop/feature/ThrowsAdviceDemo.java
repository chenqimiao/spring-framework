package com.github.chenqimiao.aop.feature;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-02-04 23:34
 **/
public class ThrowsAdviceDemo {

	public static void main(String[] args) {
		ThrowsAdviceDemo instance = new ThrowsAdviceDemo();
		ProxyFactory proxyFactory = new ProxyFactory(instance);
		proxyFactory.addAdvice(new MyThrowsAdvice(){
//			public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
//				System.out.printf("Method : %s , args : %s , target : %s, exception : %s\n",
//						method,
//						Arrays.asList(args),
//						target,
//						ex
//				);
			}
		});

		ThrowsAdviceDemo proxy = (ThrowsAdviceDemo)proxyFactory.getProxy();
		proxy.execute();

	}

	public void execute() {
		throw new RuntimeException("For Purpose.");
	}
}
