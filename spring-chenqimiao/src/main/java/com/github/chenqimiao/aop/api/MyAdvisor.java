package com.github.chenqimiao.aop.api;

import java.lang.reflect.Method;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/6 16:36
 * @Description:
 */
public class MyAdvisor implements Advisor {

	@Override
	public Advice getAdvice() {

		//没有定义Filter(比如pointcut),则代理类的所有方法都会被代理
		return new MethodBeforeAdvice(){

			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {

				System.out.println("Invoke my before advice with method named " + method.getName() );
			}
		};
	}

	@Override
	//通知也是一个bean，这个方法如果返回true,表示每个实例对应一个Advice.
	public boolean isPerInstance() {
		return false;
	}
}
