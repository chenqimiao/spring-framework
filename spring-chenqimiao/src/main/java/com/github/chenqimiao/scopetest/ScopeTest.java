package com.github.chenqimiao.scopetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/25 00:15
 * @Description:
 */
@Configuration
@ComponentScan(basePackageClasses = com.github.chenqimiao.scopetest.ScopeTest.class)
public class ScopeTest {


	public static void main(String args[]){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ScopeTest.class);
		System.out.println("a==b?" +(ac.getBean(A.class)  == ac.getBean(B.class).a));
		System.out.println("b == new b" +(ac.getBean(B.class) == ac.getBean(B.class)));
		B b = ac.getBean(B.class);
		System.out.println("b.a == new b.a" + (b.a == b.a));
		//每次输出都不一样 同@Lookup的作用(在生命周期较长的scope对象注入较短的scope对象，保证每次使用的较短的对象都是最新的)
		System.out.println(b.a);
		System.out.println(b.a);
		System.out.println(b.a);

	}


	@Scope(scopeName="prototype", proxyMode= ScopedProxyMode.TARGET_CLASS)
	@Component
	static class A{

	}

	@Component
	static class B{

		@Autowired
		public A a;
	}
}
