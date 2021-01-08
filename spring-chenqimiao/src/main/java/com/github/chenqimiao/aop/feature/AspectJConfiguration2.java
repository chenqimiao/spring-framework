package com.github.chenqimiao.aop.feature;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-01-08 14:47
 **/
@Aspect
public class AspectJConfiguration2 implements Ordered {

	@Pointcut("execution(public * *(..))")
	private void anyPublicMethod(){
		System.out.println("Match any public method."); // Do not execute.
	}

	@Before("anyPublicMethod()")
	public void before(){
		System.out.println("@Before advice2 ...");
	}

	@Around("anyPublicMethod()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("@Around advice2 ...");
		joinPoint.proceed();
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
