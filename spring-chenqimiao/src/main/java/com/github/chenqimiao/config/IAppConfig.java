package com.github.chenqimiao.config;

import com.github.chenqimiao.component.A;
import com.github.chenqimiao.component.B;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: chenqimiao
 * @Date: 2020/1/15 17:59
 * @Description:
 */
public interface IAppConfig {
	@Bean
	default A a(){
		return new A();
	}


	@Bean
	default B b(){
		return new B();
	}

}
