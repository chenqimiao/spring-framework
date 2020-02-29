package com.github.chenqimiao.applicationeventtest;

import org.aspectj.weaver.ResolvedType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ResolvableType;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/25 21:04
 * @Description:
 */
@Configuration
@ComponentScan("com.github.chenqimiao.applicationeventtest")
//@EnableAsync
public class ApplicationEventTest {

	private MyEventWithGeneric<Generic> p;

	public static void main(String args[]){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationEventTest.class);
	//	ac.publishEvent(new MyApplicationEvent("myApplicationEvent"));
	//	ac.publishEvent(new MyOtherApplicationEvent("myOtherApplicationEvent"));
		//方法体内部赋值的泛型信息是没有办法拿到的。
		ac.publishEvent(new MyEventWithGeneric<String>());


	}
}
