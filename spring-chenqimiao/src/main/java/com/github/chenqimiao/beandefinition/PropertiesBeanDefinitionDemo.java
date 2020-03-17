package com.github.chenqimiao.beandefinition;

import java.nio.charset.Charset;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/6 10:42
 * @Description: 通过Properties文件注册BeanDefinition
 */
public class PropertiesBeanDefinitionDemo {

	public static void main(String args[]){

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);

		Resource resource = new ClassPathResource("/META-INF/properties/bean-definition.properties");

		EncodedResource encodedResource = new EncodedResource(resource, Charset.forName("UTF-8"));

		int numberOfBeanDefinition = beanDefinitionReader.loadBeanDefinitions(encodedResource);

		System.out.println("load " + numberOfBeanDefinition + " 个 beanDefinition");

		System.out.println(beanFactory.getBeanDefinition("user"));


	}
}
