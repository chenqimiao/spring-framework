package com.github.chenqimiao.injection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/29 22:16
 * @Description:
 */
@Configuration
@ComponentScan("com.github.chenqimiao.injection")
public class ConstructorInjectionDemo {

	public static void main(String args[]){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(ConstructorInjectionDemo.class);
		ac.refresh();



	}
}
