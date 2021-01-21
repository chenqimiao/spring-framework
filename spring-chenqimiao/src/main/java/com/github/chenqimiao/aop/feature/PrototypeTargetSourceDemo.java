package com.github.chenqimiao.aop.feature;

import com.github.chenqimiao.aop.overview.DefaultEchoService;
import com.github.chenqimiao.aop.overview.EchoService;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.adapter.AfterReturningAdviceInterceptor;
import org.springframework.aop.target.CommonsPool2TargetSource;
import org.springframework.aop.target.PrototypeTargetSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-01-21 11:14
 **/
@Configuration
public class PrototypeTargetSourceDemo {
	@Bean
	@Scope("prototype")
	public EchoService echoService(){
		return new DefaultEchoService();
	}

	@Bean
	public PrototypeTargetSource prototypeTargetSource(){
		PrototypeTargetSource prototypeTargetSource = new PrototypeTargetSource();
		prototypeTargetSource.setTargetBeanName("echoService");
		return prototypeTargetSource;
	}

	@Bean
	public AfterReturningAdviceInterceptor afterReturningAdviceInterceptor(){
		AfterReturningAdviceInterceptor afterReturningAdviceInterceptor = new AfterReturningAdviceInterceptor(new AfterReturningAdvice() {
			@Override
			public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
				System.out.println("Target class name: " + target.getClass().getSimpleName());
			}
		});
		return afterReturningAdviceInterceptor;
	}

	@Bean
	public ProxyFactoryBean businessObject(){
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setTargetSource(prototypeTargetSource());
		proxyFactoryBean.setInterceptorNames("afterReturningAdviceInterceptor");
		return proxyFactoryBean;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(PrototypeTargetSourceDemo.class);
		ac.refresh();
		Object echoService1 = ac.getBean("echoService");
		Object echoService2 = ac.getBean("echoService");

		// Prototype
		System.out.println("(echoService1 == echoService2) = " + (echoService1 == echoService2));


		EchoService echoService3 = (EchoService)ac.getBean("businessObject");
		echoService3.echo("Hello, Qimiao Chen");

		EchoService echoService4 = (EchoService)ac.getBean("businessObject");
		echoService4.echo("Hello, Qimiao Chen");

		System.out.println("(echoService3 == echoService4) = " + (echoService3 == echoService4));
	}
}
