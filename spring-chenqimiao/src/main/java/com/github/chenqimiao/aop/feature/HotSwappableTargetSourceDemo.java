package com.github.chenqimiao.aop.feature;

import com.github.chenqimiao.aop.overview.DefaultEchoService;
import com.github.chenqimiao.aop.overview.DefaultEchoService2;
import com.github.chenqimiao.aop.overview.EchoService;
import org.springframework.aop.Advisor;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.target.HotSwappableTargetSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-01-19 14:34
 **/
@Configuration
public class HotSwappableTargetSourceDemo {

	@Bean
	public EchoService echoService(){
		return new DefaultEchoService();
	}

	@Bean
	public HotSwappableTargetSource hotSwappableTargetSource(){
		return new HotSwappableTargetSource(echoService());
	}
	@Bean
	public ProxyFactoryBean swappable(){
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setTargetSource(hotSwappableTargetSource());
		proxyFactoryBean.addAdvice(new MethodBeforeAdvice(){
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println("Target class name: " + target.getClass().getSimpleName());
			}
		});
		return proxyFactoryBean;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(HotSwappableTargetSourceDemo.class);
		ac.refresh();
		EchoService echoService = (EchoService)ac.getBean("swappable");
		echoService.echo("Hello, Qimiao Chen");
		HotSwappableTargetSource hotSwappableTargetSource = (HotSwappableTargetSource)ac.getBean("hotSwappableTargetSource");
		hotSwappableTargetSource.swap(new DefaultEchoService2());
		echoService.echo("Hello, Qimiao Chen");
	}



}
