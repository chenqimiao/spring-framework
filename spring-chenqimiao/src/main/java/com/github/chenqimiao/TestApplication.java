package com.github.chenqimiao;

import com.github.chenqimiao.component.A;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.chenqimiao.component.IndexService;
import com.github.chenqimiao.component.UserService;
import com.github.chenqimiao.config.AppConfig;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/1 16:35
 * @Description:
 */
public class TestApplication {

    public static void main(String args[]) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//      ac.getBean(IndexService.class);
//      UserService userService = ac.getBean(UserService.class);
//      userService.getUserById(1);
//		A a = ac.getBean(A.class);
//		while (true) {
//			a.printB();
//		}

    }
}
