package com.github.chenqimiao.circular.reference.resolvable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: chenqimiao
 * @Date: 2020/4/15 11:25
 * @Description:
 */
@Configuration
@ComponentScan("com.github.chenqimiao.circular.reference.resolvable")
public class ResolvableBeanCircularReferenceDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ResolvableBeanCircularReferenceDemo.class);
	}
}
