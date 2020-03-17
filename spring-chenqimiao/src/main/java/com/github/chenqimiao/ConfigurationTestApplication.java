package com.github.chenqimiao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/24 20:55
 * @Description:
 */
public class ConfigurationTestApplication {


	@Bean
	public A a(){
		return new A();
	}


	@Bean
	public B b(){
		return new B(a());
	}


	static class A{

	}
	static class B{
		public A a;
		public B(A a) {
			this.a = a;
		}
	}


	public static void main(String args[]){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ConfigurationTestApplication.class);
		System.out.println( "a == b.a ? " + ((ac.getBean("a")) == (ac.getBean("b",B.class).a)));
	}

}
