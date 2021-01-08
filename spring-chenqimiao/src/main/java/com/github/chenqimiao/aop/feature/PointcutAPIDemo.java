package com.github.chenqimiao.aop.feature;

import com.github.chenqimiao.aop.overview.DefaultEchoService;
import com.github.chenqimiao.aop.overview.EchoService;
import org.springframework.aop.Advisor;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-01-08 11:24
 **/
public class PointcutAPIDemo {

	public static void main(String[] args) {
		EchoServicePointcut echoServicePointcut = new EchoServicePointcut("echo", EchoService.class);

		Advisor advisor = new DefaultPointcutAdvisor(echoServicePointcut, new MethodBeforeAdvice() {
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println(method.getName() + " 方法被增强!");
			} 
		});
		ProxyFactory proxyFactory = new ProxyFactory(new DefaultEchoService());
		proxyFactory.addAdvisor(advisor);
		EchoService echoService = (EchoService)proxyFactory.getProxy();
		echoService.echo("Hello, Qimiao Chen");
	}
}
