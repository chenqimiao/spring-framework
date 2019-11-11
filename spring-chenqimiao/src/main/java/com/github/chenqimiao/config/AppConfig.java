package com.github.chenqimiao.config;

import com.github.chenqimiao.component.A;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.github.chenqimiao.component.UserService;
import com.github.chenqimiao.component.UserServiceImpl;
import org.springframework.context.annotation.Scope;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/1 16:34
 * @Description:
 */
@Configuration
//@ComponentScan("com.github.chenqimiao")
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
	public A a(){
		userService();
		return new A();
	}

	@Bean(initMethod = "initMethod")
	public void userService() {
		//return new UserServiceImpl();
		return;
	}

}
