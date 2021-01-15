package com.github.chenqimiao.aop.feature;

import com.github.chenqimiao.aop.feature.interceptor.EchoServiceMethodInterceptor;
import com.github.chenqimiao.aop.overview.DefaultEchoService;
import com.github.chenqimiao.aop.overview.EchoService;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.framework.adapter.AfterReturningAdviceInterceptor;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-01-14 16:06
 **/
@Configuration
public class BeanNameAutoProxyCreatorDemo {

	@Bean("echoServiceMethodInterceptor")
	public MethodInterceptor echoServiceMethodInterceptor () {
		return new EchoServiceMethodInterceptor();
	}

	@Bean
	public EchoService echoService(){
		return new DefaultEchoService();
	}

//	@Bean
//	public BeanNameAutoProxyCreator beanNameAutoProxyCreator(){
//		BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
//		beanNameAutoProxyCreator.setBeanNames("echo*");
//		beanNameAutoProxyCreator.setInterceptorNames("echoServiceMethodInterceptor");
//		return beanNameAutoProxyCreator;
//	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(BeanNameAutoProxyCreatorDemo.class);
		BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
		beanNameAutoProxyCreator.setBeanNames("echo*");
		beanNameAutoProxyCreator.setInterceptorNames("echoServiceMethodInterceptor");
		beanNameAutoProxyCreator.setBeanFactory(ac.getBeanFactory());
		ac.getBeanFactory().addBeanPostProcessor(beanNameAutoProxyCreator);
		// 注册BeanPostProcessor
		ac.refresh();
		EchoService echoService = ac.getBean(EchoService.class);
		echoService.echo("Hello, Qimiao Chen");
	}
}
