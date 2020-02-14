package com.github.chenqimiao.qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/14 13:11
 * @Description:
 */
@Configuration
public class OtherUserConfiguration {

	@Bean
	public User user3(){
		return new User(3L);
	}

	@Bean
	public User user4(){
		return new User(4L);
	}
}
