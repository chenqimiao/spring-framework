package com.github.chenqimiao.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/15 10:43
 * @Description:
 */

/**
 * Spring 提供了对@AspectJ的支持，但是仅仅是对语法的支持，并没有引入AspectJ的编译器和编织器
 *
 * 如果需要使用AspectJ的编译器和编织器 可以参考
 * https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#aop-using-aspectj
 */
@Component
//切面，所有的组成
@Aspect
@Order(2)
public class VeryUsefulAspect {

	//introduction ,配置到的bean会被代理成UsageTracked的实现，实现的方法的调用会被委托到DefaultUsageTracked
	@DeclareParents(value = "com.github.chenqimiao.component.A", defaultImpl= DefaultUsageTracked.class)
	public static UsageTracked mixin;


	//切点，包含多个连接点，而连接点指的是可执行程序的点，java中即方法
	@Pointcut(value = "execution(* com.github.chenqimiao.component..*(..))")
	public void  veryUsefulPointcut(){

	}

	//advice 后置通知建议
	@After("veryUsefulPointcut()")
	public void veryUsefulAdvice() {
		System.out.println("---------------after veryUsefulAdvice aop---------------");
	}

	//advice 前置通知建议
	@Before("veryUsefulPointcut()")
	public void veryUsefulAdvice(JoinPoint jp) {
		System.out.println("---------------before veryUsefulAdvice aop---------------");
	}


}
