package com.github.chenqimiao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/8 18:40
 * @Description:
 */
public class XmlTestApplication {

	public static void main(String args[]){
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/config/spring-config.xml");

	}

}
