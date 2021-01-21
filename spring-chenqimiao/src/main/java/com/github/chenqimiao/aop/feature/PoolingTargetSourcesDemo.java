package com.github.chenqimiao.aop.feature;

import com.github.chenqimiao.aop.overview.DefaultEchoService;
import com.github.chenqimiao.aop.overview.EchoService;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.target.CommonsPool2TargetSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-01-19 16:05
 **/
@Configuration
public class PoolingTargetSourcesDemo {

	@Bean
	@Scope("prototype")
	public EchoService echoService(){
		return new DefaultEchoService();
	}

	@Bean
	public CommonsPool2TargetSource poolTargetSource(){
		CommonsPool2TargetSource commonsPool2TargetSource = new CommonsPool2TargetSource();
		commonsPool2TargetSource.setTargetBeanName("echoService");
		commonsPool2TargetSource.setMaxSize(25);
		return commonsPool2TargetSource;
	}

	@Bean
	public ProxyFactoryBean businessObject(){
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setTargetSource(poolTargetSource());
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
		ac.register(PoolingTargetSourcesDemo.class);
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
