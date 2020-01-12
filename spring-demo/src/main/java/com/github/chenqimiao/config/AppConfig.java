package com.github.chenqimiao.config;

import com.github.chenqimiao.component.IndexService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: chenqimiao
 * @Date: 2020/1/12 13:07
 * @Description:
 */
@Configuration
public class AppConfig {

	@Bean(autowire = Autowire.BY_TYPE)
	public IndexService indexService(){
		return new IndexService();
	}



}
