package com.github.chenqimiao.configuration.xml;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Auther: chenqimiao
 * @Date: 2020/4/4 01:33
 * @Description:
 */
public class ExtensibleXmlAuthoringDemo {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

		reader.loadBeanDefinitions("classpath:com/github/chenqimiao/configuration/xml/user-bean-definition-config.xml");

		User user = beanFactory.getBean(User.class);

		System.out.println(user);

	}
}
