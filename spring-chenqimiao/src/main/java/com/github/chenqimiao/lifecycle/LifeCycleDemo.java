package com.github.chenqimiao.lifecycle;

import com.github.chenqimiao.lifecycle.processor.MyBeanDefinitionRegistryPostProcessor;
import com.github.chenqimiao.lifecycle.processor.MyBeanFactoryPostProcessor;
import com.github.chenqimiao.lifecycle.processor.MyBeanPostProcessor;
import com.github.chenqimiao.lifecycle.processor.MyDestructionAwareBeanPostProcessor;
import com.github.chenqimiao.lifecycle.processor.MyInstantiationAwareBeanPostProcessor;
import com.github.chenqimiao.lifecycle.processor.MyMergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/20 09:52
 * @Description:
 */
@Configuration
public class LifeCycleDemo {


	/**
	 * 预期输出：
	 *BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry, user.name = V0
	 * BeanFactoryPostProcessor#postProcessBeanFactory, user.name = V1
	 * InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation
	 * User#User, user.name = V2
	 * MergedBeanDefinitionPostProcessor#postProcessMergedBeanDefinition, user.name = V3
	 * InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation, user.name = V4
	 * 属性被IOC容器注入, this.name = V5
	 * BeanNameAware#setBeanName, user.name = V6
	 * BeanClassLoaderAware#setBeanClassLoader, user.name = V7
	 * BeanFactoryAware#setBeanFactory, user.name = V8
	 * BeanPostProcessor#postProcessBeforeInitialization, user.name = V9
	 * EnvironmentAware#setEnvironment, user.name = V10
	 * EmbeddedValueResolverAware#EmbeddedValueResolver, user.name = V11
	 * ResourceLoaderAware#resourceLoader, user.name = V12
	 * ApplicationEventPublisherAware#setApplicationEventPublisher, user.name = V13
	 * MessageSourceAware#setMessageSource, user.name = V14
	 * ApplicationContextAware#setApplicationContext, user.name = V15
	 * @PostConstruct method, user.name = V16
	 * InitializingBean#afterPropertiesSet, user.name = V17
	 * custom init method, user.name = V18
	 * BeanPostProcessor#postProcessAfterInitialization, user.name = V19
	 * SmartInitializingSingleton#afterSingletonsInstantiated, user.name = V20
	 * DestructionAwareBeanPostProcessor#postProcessBeforeDestruction, user.name = V21
	 * @PreDestroy method, user.name = V22
	 * Disposable#destroy, user.name = V23
	 * Disposable#destroy, user.name = V24
	 * Object#finalize, user.name = V25
	 *
	 */

	public static void main(String args[]) throws InterruptedException {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.addBeanFactoryPostProcessor(new MyBeanDefinitionRegistryPostProcessor());
		ac.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
		ac.getBeanFactory().addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
		ac.getBeanFactory().addBeanPostProcessor(new MyMergedBeanDefinitionPostProcessor());
		ac.getBeanFactory().addBeanPostProcessor(new MyBeanPostProcessor());
		ac.getBeanFactory().addBeanPostProcessor(new MyDestructionAwareBeanPostProcessor());
		ac.register(LifeCycleDemo.class);
		ac.refresh();

		DefaultListableBeanFactory factory = (DefaultListableBeanFactory)ac.getBeanFactory();

		factory.removeBeanDefinition("user");


		System.gc();
		Thread.sleep(1000);
		System.gc();
		Thread.sleep(1000);
		System.gc();
	}
}
