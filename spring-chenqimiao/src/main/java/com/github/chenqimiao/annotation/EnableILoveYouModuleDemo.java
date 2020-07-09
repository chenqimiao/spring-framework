package com.github.chenqimiao.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: Enable module 演示
 * @Author: Qimiao Chen
 * @Create: 2020-07-09 21:03
 **/
@EnableILoveYou
public class EnableILoveYouModuleDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(EnableILoveYouModuleDemo.class);
		String loveMe = ac.getBean("iLoveYou", String.class);
		System.out.println("Love me ? " + loveMe );
	}
}
