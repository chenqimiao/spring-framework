package com.github.chenqimiao.aop.api;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.interceptor.DebugInterceptor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/6 16:33
 * @Description:
 */
@Configuration
public class SpringAOPAPIDemo {

	@Bean
	public UserTarget userTarget(){
		UserTarget userTarget = new UserTarget();
		userTarget.setAge(22);
		userTarget.setName("chenqimiao");
		return userTarget;
	}

	@Bean
	public MyAdvisor myAdvisor(){
		return new MyAdvisor();
	}

	@Bean
	public DebugInterceptor debugInterceptor(){
		return new DebugInterceptor();
	}

	@Bean
	public ProxyFactoryBean userProxy() throws ClassNotFoundException {
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setProxyInterfaces(new Class<?>[]{User.class});
		//proxyFactoryBean.setInterceptorNames("myAdvisor","debugInterceptor");
		proxyFactoryBean.setInterceptorNames("myAdvisor");
		proxyFactoryBean.setTargetName("userTarget");
		return proxyFactoryBean;
	}


	public static void main(String args[]){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringAOPAPIDemo.class);
		User user = ac.getBean("userProxy", User.class);
		user.sayHello();
		Advised advised = (Advised) user;
		System.out.println(advised.getAdvisors().length);

	}
}
