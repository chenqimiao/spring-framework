package com.github.chenqimiao.config;

import com.github.chenqimiao.component.A;
import com.github.chenqimiao.component.B;
import com.github.chenqimiao.processor.CustomBeanFactoryPostProcessor;
import com.github.chenqimiao.processor.CustomBeanPostProcessor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.github.chenqimiao.component.UserService;
import com.github.chenqimiao.component.UserServiceImpl;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/1 16:34
 * @Description:
 */
@Configuration
@ComponentScan({"com.github.chenqimiao.component","com.github.chenqimiao.aop"})
//@ComponentScan(basePackageClasses = com.github.chenqimiao.component.D.class)
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableAspectJAutoProxy
//@Import(AppConfig1.class)
//@PropertySource("classpath:config/app.properties")
//@ImportResource("classpath:config/spring-config.xml")
public class AppConfig implements IAppConfig{


	@Autowired
	private Environment env;



//
//    @Bean(destroyMethod = "destroy2")
//	public B b(){
//		userService();
//		return new B();
//	}
////
//	@Bean(autowire= Autowire.BY_TYPE)
//	public A c(){
//		return new A();
//	}
//	@Bean(initMethod = "initMethod")
//	public UserService userService() {
//		System.out.println(env.getProperty("testbean.name"));
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

//	@Bean
//	public BeanDefinitionRegistryPostProcessor bdrpp(){
//		return new BeanDefinitionRegistryPostProcessor() {
//			@Override
//			public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
//					throws BeansException {
//
//			}
//
//			@Override
//			public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
//					throws BeansException {
//
//			}
//		};
//	}


//	@Bean
//	public ResourceBundleMessageSource messageSource(){
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setDefaultEncoding("UTF-8");
//		messageSource.setBasenames("format","exceptions");
//		return messageSource;
//	}

}
