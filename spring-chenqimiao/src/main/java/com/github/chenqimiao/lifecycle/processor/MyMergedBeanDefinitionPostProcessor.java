package com.github.chenqimiao.lifecycle.processor;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/20 10:22
 * @Description:
 */
public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {

	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition,
			Class<?> beanType,
			String beanName) {
		if("user".equals(beanName)){
			beanDefinition.getPropertyValues().add("name", "V3");
			System.out.println("MergedBeanDefinitionPostProcessor#postProcessMergedBeanDefinition, user.name = V3");
		}

	}
}
