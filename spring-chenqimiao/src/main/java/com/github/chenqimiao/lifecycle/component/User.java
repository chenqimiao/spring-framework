package com.github.chenqimiao.lifecycle.component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/20 09:50
 * @Description:
 */
public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware,
		EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware,
		ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware, InitializingBean,
		SmartInitializingSingleton, DisposableBean {

	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {

		if(Thread.currentThread().getStackTrace()[2].toString().startsWith("java.")){
			//反射调用，属性被IOC容器注入
			this.name = "V5";
			System.out.println("属性被IOC容器注入, user.name = " + this.name);
		}else {
			this.name = name;

		}

	}

	public User(){
		this.name = "V2";
		System.out.println("User#User, user.name = " + this.name);
	}
	@Override
	public void setBeanName(String name) {
		this.name = "V6";
		System.out.println("BeanNameAware#setBeanName, user.name = " + this.name);
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.name = "V7";
		System.out.println("BeanClassLoaderAware#setBeanClassLoader, user.name = " + this.name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.name = "V8";
		System.out.println("BeanFactoryAware#setBeanFactory, user.name = " + this.name);
	}


	@Override
	public void setEnvironment(Environment environment) {
		this.name = "V10";
		System.out.println("EnvironmentAware#setEnvironment, user.name = " + this.name);
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.name = "V11";
		System.out.println("EmbeddedValueResolverAware#EmbeddedValueResolver, user.name = " + this.name);
	}


	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.name = "V12";
		System.out.println("ResourceLoaderAware#resourceLoader, user.name = " + this.name);
	}


	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.name = "V13";
		System.out.println("ApplicationEventPublisherAware#setApplicationEventPublisher, user.name = " + this.name);
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.name = "V14";
		System.out.println("MessageSourceAware#setMessageSource, user.name = " + this.name);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.name = "V15";
		System.out.println("ApplicationContextAware#setApplicationContext, user.name = " + this.name);
	}

	@PostConstruct
	public void postConstruct(){
		this.name = "V16";
		System.out.println("@PostConstruct method, user.name = " + this.name);
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		this.name = "V17";
		System.out.println("InitializingBean#afterPropertiesSet, user.name = " + this.name);
	}

	public void customInit(){
		this.name = "V18";
		System.out.println("Custom init method, user.name = " + this.name);
	}


	@Override
	public void afterSingletonsInstantiated() {
		this.name = "V20";
		System.out.println("SmartInitializingSingleton#afterSingletonsInstantiated, user.name = " + this.name);
	}

	@PreDestroy
	public void preDestroy(){
		this.name = "V22";
		System.out.println("@PreDestroy method, user.name = " + this.name);
	}

	@Override
	public void destroy() throws Exception {
		this.name = "V23";
		System.out.println("Disposable#destroy, user.name = " + this.name);
	}

	public void customDestroy(){
		this.name = "V24";
		System.out.println("Custom destroy method, user.name = " + this.name);
	}

	@Override
	public void finalize() throws Throwable {
		super.finalize();
		this.name = "V25";
		System.out.println("Object#finalize, user.name = " + this.name);
	}
}
