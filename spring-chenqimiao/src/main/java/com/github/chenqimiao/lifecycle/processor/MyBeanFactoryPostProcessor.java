package com.github.chenqimiao.lifecycle.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/20 10:16
 * @Description:
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("user");
		beanDefinition.getPropertyValues().add("name", "V1");

		System.out.println("BeanFactoryPostProcessor#postProcessBeanFactory, user.name = V1");
	}
}
