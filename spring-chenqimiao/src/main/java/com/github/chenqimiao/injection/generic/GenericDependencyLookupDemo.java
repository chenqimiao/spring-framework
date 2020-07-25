package com.github.chenqimiao.injection.generic;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ResolvableType;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @Description: 泛型依赖查找示例代码
 * @Author: Qimiao Chen
 * @Create: 2020-07-25 20:45
 **/
@Configuration(proxyBeanMethods = false)
public class GenericDependencyLookupDemo {

	private MyTemplate<Serializable, Serializable> myTemplate;

	private MyTemplate<String, String> myStringTemplate;

	@SuppressWarnings("rawtypes")
	private MyTemplate myNoGenericTemplate;

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws NoSuchFieldException {

		// 实例化上下文
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		// 注册 MyTemplateConfiguration
		context.register(MyTemplateConfiguration.class);

		// 注册 GenericInjectionDemo
		context.register(GenericInjectionDemo.class);

		// 刷新上下文
		context.refresh();

		Field field = GenericDependencyLookupDemo.class.getDeclaredField("myTemplate");

		Class<?> clazz = field.getType();

		// 依赖查找，不支持严格泛型匹配
		MyTemplate myTemplate = (MyTemplate)context.getBean(clazz);

		System.out.println(myTemplate);

		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getBeanFactory();

		ResolvableType resolvableType = ResolvableType.forField(field);

		String[] beanNames = beanFactory.getBeanNamesForType(resolvableType);
		// 0
		System.out.println(beanNames.length);

		Field myStringTemplateField = GenericDependencyLookupDemo.class.getDeclaredField("myStringTemplate");
		// 1
		System.out.println(beanFactory.getBeanNamesForType(ResolvableType.forField(myStringTemplateField)).length);

		Field myNoGenericTemplateField = GenericDependencyLookupDemo.class.getDeclaredField("myNoGenericTemplate");
		// 1
		System.out.println(beanFactory.getBeanNamesForType(ResolvableType.forField(myNoGenericTemplateField)).length);



	}
}
