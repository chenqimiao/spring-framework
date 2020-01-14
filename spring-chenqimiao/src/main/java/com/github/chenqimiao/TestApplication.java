package com.github.chenqimiao;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.util.Map;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.chenqimiao.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/1 16:35
 * @Description:
 */
public class TestApplication {

    public static void main(String args[]) {
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
//        //ac.getBeanFactory().ignoreDependencyInterface(BAware.class);
//       // ac.getBeanFactory().ignoreDependencyType(B.class);
//        ac.register(AppConfig.class);
//		//ac.scan("com.github.chenqimiao.component");
//        ac.refresh();
//		ac.removeBeanDefinition("b");
        //ac.removeBeanDefinition("b");
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

//		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("config/spring-config.xml");
//		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)ac.getBeanFactory();
//		beanFactory.removeBeanDefinition("c");
//		BeanDefinition dbd = beanFactory.getBeanDefinition("d");
//		System.out.println(dbd);
//		Object o = ac.getBean("d");
//		System.out.println(o);

		AnnotationMetadata annotationMetadata = AnnotationMetadata.introspect(AppConfig.class);
		System.out.println(annotationMetadata.isAnnotated(Component.class.getName()));
		System.out.println(annotationMetadata.hasMetaAnnotation(Component.class.getName()));
		System.out.println(annotationMetadata.hasAnnotatedMethods(Bean.class.getName()));
		System.out.println(annotationMetadata.hasAnnotation(Configuration.class.getName()));
		Map map = annotationMetadata.getAllAnnotationAttributes(Configuration.class.getName());

		System.out.println(map);
	}
}
