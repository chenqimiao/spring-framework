package com.github.chenqimiao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
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
