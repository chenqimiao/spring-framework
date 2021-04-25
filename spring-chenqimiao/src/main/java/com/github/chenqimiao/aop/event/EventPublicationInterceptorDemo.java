package com.github.chenqimiao.aop.event;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.EventPublicationInterceptor;

import java.lang.reflect.Method;

/**
 * @Description: EventPublicationInterceptor demo
 * @Author: Qimiao Chen
 * @Create: 2021-04-25 17:21
 **/
@Configuration
@EnableAspectJAutoProxy
public class EventPublicationInterceptorDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(EventPublicationInterceptorDemo.class, Executor.class, EventPublicationExecutor.class);
		ac.refresh();

		Executor executor = ac.getBean("executor", Executor.class);
		EventPublicationExecutor eventPublicationExecutor = ac.getBean(EventPublicationExecutor.class);

		// AOP 的方式进行事件发布
		executor.execute();

		// 静态的方式发布事件
		eventPublicationExecutor.execute();



	}


	// 1. pointcut 声明
	@Bean
	public Pointcut pointcut() {
		return new StaticMethodMatcherPointcut() {
			@Override
			public boolean matches(Method method, Class<?> targetClass) {
				return "execute".equals(method.getName()) && Executor.class.equals(targetClass);
			}
		};
	}

	// 2. EventPublicationInterceptor 声明
	@Bean
	public EventPublicationInterceptor eventPublicationInterceptor() {
		EventPublicationInterceptor eventPublicationInterceptor = new EventPublicationInterceptor();
		eventPublicationInterceptor.setApplicationEventClass(ExecutedEvent.class);
		return eventPublicationInterceptor;
	}


	// 3. Advisor 声明

	@Bean
	public Advisor advisor(Pointcut pointcut, EventPublicationInterceptor eventPublicationInterceptor) {
		return new DefaultPointcutAdvisor(pointcut, eventPublicationInterceptor);
	}


	// 4. listener 声明
	@EventListener(ExecutedEvent.class)
	public void onExecutedEvent(ExecutedEvent executedEvent) {
		System.out.println(executedEvent.getSource());
	}
}

