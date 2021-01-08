package com.github.chenqimiao.aop.feature;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-12-31 15:57
 **/
public class AspectXmlConfig {

	public void before(){
		System.out.println("@Before advice ...");
	}

	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("@Around advice ...");
		joinPoint.proceed();
	}
}
