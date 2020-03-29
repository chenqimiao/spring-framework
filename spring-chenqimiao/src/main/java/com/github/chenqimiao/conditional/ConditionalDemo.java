package com.github.chenqimiao.conditional;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/29 16:11
 * @Description:
 */
public class ConditionalDemo {

	public static void main(String[] args){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(Configuration1.class, Configuration3.class);
		DefaultListableBeanFactory listableBeanFactory = (DefaultListableBeanFactory)ac.getBeanFactory();
		listableBeanFactory.registerBeanDefinition("configuration1",
				BeanDefinitionBuilder.genericBeanDefinition(Configuration1.class).getBeanDefinition());
		ac.refresh();
	}
}
