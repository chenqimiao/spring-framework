package com.github.chenqimiao.environment;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: PropertyPlaceholderConfigurer demo
 * @Author: Qimiao Chen
 * @Create: 2020-07-11 11:51
 **/
public class PropertyPlaceholderConfigurerDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("/META-INF/environment/placeholder-resolver.xml");

		User user = context.getBean("user", User.class);

		System.out.println(user);

		context.close();
	}
}
