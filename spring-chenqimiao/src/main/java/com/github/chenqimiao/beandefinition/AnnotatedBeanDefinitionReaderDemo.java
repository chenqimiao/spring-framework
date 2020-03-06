package com.github.chenqimiao.beandefinition;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/6 10:52
 * @Description:
 */
public class AnnotatedBeanDefinitionReaderDemo {


	public static void main(String args[]){
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(factory);
		reader.register(User.class);
		System.out.println(factory.getBeanDefinition("user"));

	}

}
