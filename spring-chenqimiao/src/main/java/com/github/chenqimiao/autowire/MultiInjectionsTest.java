package com.github.chenqimiao.autowire;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/4 14:52
 * @Description:
 */
//@Configuration
//@ImportResource
public class MultiInjectionsTest {



	@Bean
	public B b(){
		return new B();
	}

	//@Bean方法注入本质还是构造器自动注入，所以和Autowire.BY_NAME/BY_TYPE冲突,不能一起使用
	@Bean(autowire = Autowire.BY_NAME)
	public A a(B b){
		return new A();
	}

	public static void main(String args[]){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(MultiInjectionsTest.class);
		ac.refresh();
	}
}
