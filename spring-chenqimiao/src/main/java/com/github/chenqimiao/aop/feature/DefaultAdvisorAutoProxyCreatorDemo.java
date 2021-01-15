package com.github.chenqimiao.aop.feature;

import com.github.chenqimiao.aop.feature.interceptor.EchoServiceMethodInterceptor;
import com.github.chenqimiao.aop.overview.DefaultEchoService;
import com.github.chenqimiao.aop.overview.EchoService;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-01-14 17:26
 **/
@Configuration
public class DefaultAdvisorAutoProxyCreatorDemo {
	@Bean("echoServiceMethodInterceptor")
	public MethodInterceptor echoServiceMethodInterceptor () {
		return new EchoServiceMethodInterceptor();
	}

	@Bean
	public EchoService echoService(){
		return new DefaultEchoService();
	}

	@Bean
	public Pointcut echoServicePointcut(){
		EchoServicePointcut echoServicePointcut = new EchoServicePointcut("echo", EchoService.class);
		return echoServicePointcut;
	}

	@Bean
	public Advisor advisor(){
		Advisor advisor = new DefaultPointcutAdvisor(echoServicePointcut(), echoServiceMethodInterceptor());
		return advisor;
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
		return new DefaultAdvisorAutoProxyCreator();
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(DefaultAdvisorAutoProxyCreatorDemo.class);
		ac.refresh();
		EchoService echoService = ac.getBean(EchoService.class);
		echoService.echo("Hello, Qimiao Chen");
	}
}
