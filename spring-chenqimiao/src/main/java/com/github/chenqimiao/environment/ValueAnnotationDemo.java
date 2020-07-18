package com.github.chenqimiao.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: @Value demo
 * @Author: Qimiao Chen
 * @Create: 2020-07-18 11:45
 **/
public class ValueAnnotationDemo {

	@Value("${user.name}")
	private String userName;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 注册 Configuration Class
		context.register(ValueAnnotationDemo.class);

		// 启动 Spring 应用上下文
		context.refresh();

		ValueAnnotationDemo valueAnnotationDemo = context.getBean(ValueAnnotationDemo.class);

		System.out.println(valueAnnotationDemo.userName); // "系统用户名"

		// 关闭 Spring 应用上下文
		context.close();
	}
}
