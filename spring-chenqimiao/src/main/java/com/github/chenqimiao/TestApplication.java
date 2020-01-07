package com.github.chenqimiao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.chenqimiao.config.AppConfig;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/1 16:35
 * @Description:
 */
public class TestApplication {

    public static void main(String args[]) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        //ac.getBeanFactory().ignoreDependencyInterface(BAware.class);
       // ac.getBeanFactory().ignoreDependencyType(B.class);
        ac.register(AppConfig.class);
        ac.refresh();
//        A a = ac.getBean(A.class);
//		System.out.println(a.getB());
//      ac.getBean(IndexService.class);
//      UserService userService = ac.getBean(UserService.class);
//      userService.getUserById(1);
//		A a = ac.getBean(A.class);
//		while (true) {
//			a.printB();
//		}


//		String englishMessage = ac.getMessage("message", null, "Default", Locale.ENGLISH);
//		System.out.println(englishMessage);
//
//		String zhMessage = ac.getMessage("message", null, "Default", Locale.SIMPLIFIED_CHINESE);
//		System.out.println(zhMessage);
//
//		String message = ac.getMessage("argument.required",
//				new Object [] {"userDao"}, "Required", Locale.ENGLISH);
//		System.out.println(message);
	}
}
