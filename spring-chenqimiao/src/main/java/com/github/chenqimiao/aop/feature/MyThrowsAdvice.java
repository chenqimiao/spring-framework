package com.github.chenqimiao.aop.feature;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-02-04 23:51
 **/
public class MyThrowsAdvice implements ThrowsAdvice {
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
		System.out.printf("Method : %s , args : %s , target : %s, exception : %s\n",
				method,
				Arrays.asList(args),
				target,
				ex
		);
	}
}
