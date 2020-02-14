package com.github.chenqimiao.qualifier;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/14 13:09
 * @Description:
 */
@Configuration
public class AutowiredDependencyInjectionDemo {

	@Autowired
	private Collection<User> allUsers;


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
		ac.register(AutowiredDependencyInjectionDemo.class);
		ac.register(OtherUserConfiguration.class);
		ac.refresh();
		AutowiredDependencyInjectionDemo demo = ac.getBean(AutowiredDependencyInjectionDemo.class);
		System.out.println(demo.allUsers);

	}

}
