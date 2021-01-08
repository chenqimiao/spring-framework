package com.github.chenqimiao.aop.feature;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-12-31 15:09
 **/
@Aspect
@Order // 默认是最低优先级
public class AspectJConfiguration {

	@Pointcut("execution(public * *(..))")
	private void anyPublicMethod(){
		System.out.println("Match any public method."); // Do not execute.
	}

	@Before("anyPublicMethod()")
	public void before(){
		System.out.println("@Before advice ...");
	}

	@Around("anyPublicMethod()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("@Around advice ...");
		joinPoint.proceed();
	}
}
