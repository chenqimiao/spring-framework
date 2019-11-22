package com.github.chenqimiao.config;

import com.github.chenqimiao.component.A;
import com.github.chenqimiao.component.B;
import com.github.chenqimiao.processor.CustomBeanFactoryPostProcessor;
import com.github.chenqimiao.processor.CustomBeanPostProcessor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.github.chenqimiao.component.UserService;
import com.github.chenqimiao.component.UserServiceImpl;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.annotation.Order;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/1 16:34
 * @Description:
 */
@Configuration
//@ComponentScan("com.github.chenqimiao")
@EnableAspectJAutoProxy
@Import(AppConfig1.class)
public class AppConfig {
//
    @Bean
	public B b(){
		//userService();
		return new B();
	}
//
//	@Bean
//	public A c(){
//		return new A();
//	}
//	@Bean(initMethod = "initMethod")
//	public UserService userService() {
//    	return new UserServiceImpl();
//	}

//	@Bean
//	public CustomBeanPostProcessor customBeanPostProcessor(){
//
//		return new CustomBeanPostProcessor();
//	}
//
//	@Bean
//	public CustomBeanPostProcessor customBeanPostProcessor1(){
//		return new CustomBeanPostProcessor();
//	}
////	@Bean
////	public CustomBeanFactoryPostProcessor customBeanFactoryPostProcessor(){
////    	return new CustomBeanFactoryPostProcessor();
////	}
//
//	@Bean
//	public SimpleApplicationEventMulticaster applicationEventMulticaster(ExecutorService executor ){
//		SimpleApplicationEventMulticaster applicationEventMulticaster = new SimpleApplicationEventMulticaster();
//		applicationEventMulticaster.setTaskExecutor(executor);
//		return applicationEventMulticaster;
//	}
//
//	@Bean
//	public ExecutorService executor(){
//		return Executors.newFixedThreadPool(5);
//	}

}
