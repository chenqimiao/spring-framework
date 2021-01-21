package com.github.chenqimiao.aop.feature;

import com.github.chenqimiao.aop.overview.DefaultEchoService;
import com.github.chenqimiao.aop.overview.EchoService;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.adapter.AfterReturningAdviceInterceptor;
import org.springframework.aop.target.PrototypeTargetSource;
import org.springframework.aop.target.ThreadLocalTargetSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-01-21 11:24
 **/
@Configuration
public class ThreadLocalTargetSourceDemo {
	@Bean
	@Scope("prototype")
	public EchoService echoService(){
		return new DefaultEchoService();
	}

	@Bean
	public ThreadLocalTargetSource threadLocalTargetSource(){
		ThreadLocalTargetSource threadLocalTargetSource = new ThreadLocalTargetSource();
		threadLocalTargetSource.setTargetBeanName("echoService");
		return threadLocalTargetSource;
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
		proxyFactoryBean.setTargetSource(threadLocalTargetSource());
		proxyFactoryBean.setInterceptorNames("afterReturningAdviceInterceptor");
		return proxyFactoryBean;
	}

	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(ThreadLocalTargetSourceDemo.class);
		ac.refresh();
		Object echoService1 = ac.getBean("echoService");
		Object echoService2 = ac.getBean("echoService");

		// Prototype
		System.out.println("(echoService1 == echoService2) = " + (echoService1 == echoService2));

		EchoService[] echoServices = new EchoService[3];

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				echoServices[0] = (EchoService)ac.getBean("businessObject");


			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				echoServices[1] = (EchoService)ac.getBean("businessObject");
			}
		});

		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();

		System.out.println("(echoServices[0] == echoServices[1]) = " + (echoServices[0] == echoServices[1]));




	}
}
