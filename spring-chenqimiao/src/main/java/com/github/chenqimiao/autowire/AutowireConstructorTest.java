package com.github.chenqimiao.autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/25 02:35
 * @Description:
 */
@Configuration
@ComponentScan("com.github.chenqimiao.autowire")
@PropertySource("classpath:META-INF/properties/xxx.properties")
public class AutowireConstructorTest {

	public static void main(String args[]){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutowireConstructorTest.class);
		ac.getBean(A.class);
	}
}
