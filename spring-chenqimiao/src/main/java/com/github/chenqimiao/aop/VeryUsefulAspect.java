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
//切面，所有的组成
@Aspect
@Order(2)
public class VeryUsefulAspect {
	//切点，包含多个连接点，而连接点指的是可执行程序的点，java中即方法
	@Pointcut(value = "execution(* com.github.chenqimiao.component..*(..))")
	public void  veryUsefulPointcut(){

	}

	//advice 通知建议
	@After("veryUsefulPointcut()")
	public void veryUsefulAdvice() {
		System.out.println("---------------after veryUsefulAdvice aop---------------");
	}
	
	//advice 通知建议
	@Before("veryUsefulPointcut()")
	public void veryUsefulAdvice(JoinPoint jp) {
		System.out.println("---------------before veryUsefulAdvice aop---------------");
	}
}
