package com.github.chenqimiao.aop.feature;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.Random;

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
	public void before() throws Exception{
//		Random random = new Random();
//		if (random.nextBoolean()){
//			throw new RuntimeException("On purpose.");
//		}
		System.out.println("@Before advice ...");
	}

	@Around("anyPublicMethod()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("@Around advice ...");
		joinPoint.proceed();
	}

	@After("anyPublicMethod()")
	public void after() throws Throwable{
		System.out.println("@After advice ...");
	}

	@AfterReturning("anyPublicMethod()")
	public void afterReturning() throws Throwable{
		System.out.println("@AfterReturning advice ...");
	}

	@AfterThrowing("anyPublicMethod()")
	public void afterThrowing() throws Throwable{
		System.out.println("@AfterThrowing advice ...");
	}


}
