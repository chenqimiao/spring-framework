package com.github.chenqimiao.circular.reference;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: chenqimiao
 * @Date: 2020/4/15 10:12
 * @Description:
 */
@Configuration
@ComponentScan("com.github.chenqimiao.circular.reference")
public class MixedBeanFactoryBeanCircularReferenceDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MixedBeanFactoryBeanCircularReferenceDemo.class);
		// FactoryBean之间的循环依赖是无法解决的，因为半成品的Bean无法定义.
		Husband husband = ac.getBean(Husband.class);
		System.out.println(husband.getWife());
	}
}
