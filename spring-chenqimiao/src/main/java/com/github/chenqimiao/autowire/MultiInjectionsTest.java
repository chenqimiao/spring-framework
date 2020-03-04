package com.github.chenqimiao.autowire;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/4 14:52
 * @Description:
 */
@Configuration
@ImportResource
public class MultiInjectionsTest {



	@Bean
	public B b(){
		return new B();
	}

	//构造器自动注入和方法注入会冲突
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
