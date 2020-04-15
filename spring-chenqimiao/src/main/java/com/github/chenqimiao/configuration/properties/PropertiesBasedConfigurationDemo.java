package com.github.chenqimiao.configuration.properties;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Auther: chenqimiao
 * @Date: 2020/4/4 19:00
 * @Description:
 */
@Configuration(proxyBeanMethods = false)
@PropertySource(value = "/META-INF/properties/xxx.properties")
public class PropertiesBasedConfigurationDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PropertiesBasedConfigurationDemo.class);
		String xxx = ac.getEnvironment().getProperty("xxx");
		System.out.println(xxx);

	}
}
