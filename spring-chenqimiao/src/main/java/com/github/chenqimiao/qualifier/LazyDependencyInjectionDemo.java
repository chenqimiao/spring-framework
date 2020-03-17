package com.github.chenqimiao.qualifier;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/14 15:00
 * @Description:
 */
@Configuration
public class LazyDependencyInjectionDemo {


//	@Autowired
//	private ObjectFactory<User> objectFactory; //注入单个bean

	@Autowired
	private ObjectProvider<User> objectProvider; //注入单个bean或者集合

//	@Autowired
//	private ObjectFactory<Set<User>> objectFactory; //注入集合


	@Autowired
	private User[] users;

	@Bean
	public User user1(){
		return new User(1L);
	}

	@Bean
	public User user2(){
		return new User(2L);
	}


	public static void main(String args[]){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(LazyDependencyInjectionDemo.class);
		ac.refresh();
		LazyDependencyInjectionDemo demo = ac.getBean(LazyDependencyInjectionDemo.class);
//		System.out.println(demo.objectFactory.getObject());
//		System.out.println(demo.objectProvider.getIfAvailable());
//		System.out.println(demo.objectFactory.getObject());
		demo.objectProvider.forEach(System.out::println);

		if (demo.users != null){
			for (User u : demo.users){
				System.out.println(u);
			}
		}

	}
}
