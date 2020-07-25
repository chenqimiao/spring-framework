package com.github.chenqimiao.injection.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * @Description: 泛型注入示例代码
 * @Author: Qimiao Chen
 * @Create: 2020-07-25 19:08
 **/
@Configuration(proxyBeanMethods = false)
public class GenericInjectionDemo {

	@Autowired
	@SuppressWarnings("rawtypes")
	private MyTemplate myTemplate;

	@Autowired
	private MyTemplate<String, String> myStringTemplate;

	// @Autowired
	// Bean声明和依赖注入声明的泛型信息不匹配，则无法进行依赖注入
	// private MyTemplate<Serializable, Serializable> mySerializableTemplate;


	public static void main(String[] args) {
		// 实例化上下文
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		// 注册 MyTemplateConfiguration
		context.register(MyTemplateConfiguration.class);

		// 注册 GenericInjectionDemo
		context.register(GenericInjectionDemo.class);

		// 刷新上下文
		context.refresh();

		// 进行依赖查找
		GenericInjectionDemo genericInjectionDemo = context.getBean(GenericInjectionDemo.class);

		// 打印 myTemplate
		System.out.println(genericInjectionDemo.myTemplate);
	}


}
