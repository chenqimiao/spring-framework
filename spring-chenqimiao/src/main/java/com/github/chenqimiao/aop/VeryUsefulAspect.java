package com.github.chenqimiao.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/15 10:43
 * @Description:
 */
@Component
@Aspect
@Order(2)
public class VeryUsefulAspect {

	@Pointcut(value = "execution(* com.github.chenqimiao.component..*(..))")
	public void  veryUsefulPointcut(){

	}


	@After("veryUsefulPointcut()")
	public void veryUsefulAdvice() {
		System.out.println("---------------after veryUsefulAdvice aop---------------");
	}

	@Before("veryUsefulPointcut()")
	public void veryUsefulAdvice(JoinPoint jp) {
		System.out.println("---------------before veryUsefulAdvice aop---------------");
	}
}
