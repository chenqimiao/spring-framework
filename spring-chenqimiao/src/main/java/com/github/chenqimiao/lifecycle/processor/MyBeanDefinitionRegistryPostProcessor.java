package com.github.chenqimiao.lifecycle.processor;

import com.github.chenqimiao.lifecycle.component.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/20 09:57
 * @Description:
 */
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
			throws BeansException {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		builder.addPropertyReference("name", "V0");
		builder.setInitMethodName("customInit");
		builder.setDestroyMethodName("customDestroy");
		registry.registerBeanDefinition("user", builder.getBeanDefinition());
		System.out.println("BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry, user.name = V0");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {

	}
}
