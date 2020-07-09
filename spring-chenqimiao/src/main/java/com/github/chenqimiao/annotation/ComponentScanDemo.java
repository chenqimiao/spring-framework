package com.github.chenqimiao.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-07-07 20:45
 **/
@ComponentScan(basePackages = {"com.github.chenqimiao.annotation"})
@Configuration
public class ComponentScanDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(ComponentScanDemo.class);
		ac.refresh();
		ac.getBean(TestClass.class);
	}
}
