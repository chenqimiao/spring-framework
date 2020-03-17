package com.github.chenqimiao;

import com.github.chenqimiao.aop.DefaultUsageTracked;
import com.github.chenqimiao.aop.UsageTracked;
import com.github.chenqimiao.component.A;
import com.github.chenqimiao.config.AppConfig;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/1 16:35
 * @Description:
 */
public class TestApplication {

    public static void main(String args[]) {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
        //ac.getBeanFactory().ignoreDependencyInterface(BAware.class);
//       // ac.getBeanFactory().ignoreDependencyType(B.class);
        ac.register(AppConfig.class);
//		//ac.scan("com.github.chenqimiao.component");
        ac.refresh();

        UsageTracked usageTracked = (UsageTracked)ac.getBean("a");

		System.out.println(usageTracked instanceof DefaultUsageTracked);
		System.out.println(usageTracked instanceof A);

		ObjectProvider<A> objectProvider = ac.getBeanProvider(A.class);
		objectProvider.getObject();
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

//		AnnotationMetadata annotationMetadata = AnnotationMetadata.introspect(AppConfig.class);
//		System.out.println(annotationMetadata.isAnnotated(Component.class.getName()));
//		System.out.println(annotationMetadata.hasMetaAnnotation(Component.class.getName()));
//		System.out.println(annotationMetadata.hasAnnotatedMethods(Bean.class.getName()));
//		System.out.println(annotationMetadata.hasAnnotation(BeanPostProcessorInConfiguration.class.getName()));
//		Map map = annotationMetadata.getAllAnnotationAttributes(BeanPostProcessorInConfiguration.class.getName());
//
//		System.out.println(map);
	}
}
