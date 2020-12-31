package com.github.chenqimiao.aop.feature;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-12-31 15:09
 **/
@Aspect
public class AspectJConfiguration {

	@Pointcut("execution(public * *(..))")
	private void anyPublicMethod(){
		System.out.println("Match any public method."); // Do not execute.
	}

	@Before("anyPublicMethod()")
	public void before(){
		System.out.println("@Before advice ...");
	}
}
