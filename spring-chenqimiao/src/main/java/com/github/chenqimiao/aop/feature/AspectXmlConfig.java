package com.github.chenqimiao.aop.feature;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;

import java.util.Random;

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
		Random random = new Random();
		if (random.nextBoolean()){
			throw new RuntimeException("On purpose.");
		}
		System.out.println("@Around advice ...");
		joinPoint.proceed();
	}


	public void after() throws Throwable{
		System.out.println("@After advice ...");
	}

	public void afterReturning() throws Throwable{
		System.out.println("@AfterReturning advice ...");
	}

	public void afterThrowing() throws Throwable{
		System.out.println("@AfterThrowing advice ...");
	}
}
