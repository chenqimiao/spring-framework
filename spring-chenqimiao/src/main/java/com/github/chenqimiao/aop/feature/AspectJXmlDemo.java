package com.github.chenqimiao.aop.feature;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-12-31 15:51
 **/
public class AspectJXmlDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/aop/aspectj.xml");
		AspectJXmlDemo aspectJXmlDemo = context.getBean(AspectJXmlDemo.class);
		aspectJXmlDemo.execute();
	}

	public String execute(){
		System.out.println("execute() ...");
		return "execute()";
	}
}
