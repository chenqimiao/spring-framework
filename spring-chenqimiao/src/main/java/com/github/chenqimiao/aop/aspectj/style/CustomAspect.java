package com.github.chenqimiao.aop.aspectj.style;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/14 15:01
 * @Description:
 */
@Aspect
public class CustomAspect {

	//..表示任意数量任意类型  *表示单个数量任意类型
	@Pointcut(value = "execution(* com.github.chenqimiao.aop.aspectj.style.User.*(..))")
	public void pointCut(){

	}

	@Before("pointCut()")
	public void beforeAdvice(JoinPoint jp) {
		System.out.println("Aspectj style before advice");
	}

	//方法返回后执行，方法抛出异常该Advice无法执行
	@AfterReturning("pointCut()")
	public void afterReturningAdvice(JoinPoint jp){
		System.out.println("Aspectj style AfterReturning Advice advice");
	}

	//方法抛出异常后执行
	@AfterThrowing("pointCut()")
	public void afterThrowingAdvice(JoinPoint jp){
		System.out.println("Aspectj style AfterThrowingAdvice Advice advice");
	}

	//方法执行结束后执行，无论方法是否由异常抛出
	@After("pointCut()")
	public void afterAdvice(JoinPoint jp){
		System.out.println("Aspectj style After Advice advice");
	}

	//环绕通知
	@Around("pointCut()")
	public void aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("Aspectj style Around Advice advice before jp.proceed");
		jp.proceed();
		System.out.println("Aspectj style Around Advice advice after jp.proceed");
	}
}
