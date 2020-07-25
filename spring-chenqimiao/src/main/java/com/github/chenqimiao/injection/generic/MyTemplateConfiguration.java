package com.github.chenqimiao.injection.generic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-07-25 19:21
 **/
@Configuration(proxyBeanMethods = false)
public class MyTemplateConfiguration {

	@Bean
	public MyTemplate<String, String> myTemplate() {
		return new MyTemplate<>("String, String");
	}

}
