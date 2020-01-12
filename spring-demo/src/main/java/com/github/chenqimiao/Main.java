package com.github.chenqimiao;

import com.github.chenqimiao.component.AbstractUser;
import com.github.chenqimiao.component.IndexService;
import com.github.chenqimiao.component.UserFactory;
import com.github.chenqimiao.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: chenqimiao
 * @Date: 2020/1/12 13:18
 * @Description:
 */
public class Main {

	public static void main(String args[]){

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(AppConfig.class);
		ac.getBeanFactory().registerResolvableDependency(AbstractUser.class, new UserFactory());
		ac.refresh();
		IndexService indexService = ac.getBean(IndexService.class);

		indexService.printUserName();
	}
}
