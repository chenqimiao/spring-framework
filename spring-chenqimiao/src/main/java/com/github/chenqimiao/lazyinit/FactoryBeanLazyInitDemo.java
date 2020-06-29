package com.github.chenqimiao.lazyinit;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-06-29 10:33
 **/
@Configuration
public class FactoryBeanLazyInitDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(FactoryBeanLazyInitDemo.class);
		User user = ac.getBean("user", User.class);
		System.out.println(user);
		User user1 = ac.getBean("user1", User.class);
		System.out.println(user1);
	}

	@Bean
	public UserFactoryBean user() {
		return new UserFactoryBean();
	}

	@Bean
	public MyEventListenerFactoryBean myEventListener() {
		return new MyEventListenerFactoryBean();
	}

	@Bean
	@Lazy
	public User user1(){
		return new User("wahaha");
	}
}
