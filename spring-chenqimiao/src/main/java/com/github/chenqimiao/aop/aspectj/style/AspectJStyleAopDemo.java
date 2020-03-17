package com.github.chenqimiao.aop.aspectj.style;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/14 15:39
 * @Description:
 */
@Configuration
@EnableAspectJAutoProxy
public class AspectJStyleAopDemo {


	@Bean
	public User user(){
		return new User();
	}

	@Bean
	public CustomAspect customAspect(){
		return new CustomAspect();
	}


	public static void main(String args[]){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AspectJStyleAopDemo.class);

		User user = ac.getBean("user", User.class);

		user.advisedMethod();

	}
}
