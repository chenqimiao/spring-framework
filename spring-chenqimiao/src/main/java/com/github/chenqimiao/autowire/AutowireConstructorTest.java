package com.github.chenqimiao.autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/25 02:35
 * @Description:
 */
@Configuration
@ComponentScan("com.github.chenqimiao.autowire")
public class AutowireConstructorTest {

	public static void main(String args[]){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutowireConstructorTest.class);
		ac.getBean(A.class);
	}
}
