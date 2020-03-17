package com.github.chenqimiao.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/13 20:57
 * @Description:
 */
//@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
		System.out.println("Invoke CustomBeanFactoryPostProcessor#postProcessBeanFactory1111111111111");
	}
}
