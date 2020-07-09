package com.github.chenqimiao.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: I love you 配置类
 * @Author: Qimiao Chen
 * @Create: 2020-07-09 20:41
 **/
@Configuration
public class ILoveYouConfiguration {

	@Bean
	public String iLoveYou(){
		return "I love you";
	}
}
