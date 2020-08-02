package com.github.chenqimiao.lifecycle.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

import static org.springframework.context.support.LiveBeansView.MBEAN_DOMAIN_PROPERTY_NAME;

/**
 * @Description: LiveBeansView 示例
 * @Author: Qimiao Chen
 * @Create: 2020-08-02 10:52
 **/
public class LiveBeansViewDemo {

	public static void main(String[] args) throws IOException {
		// 添加 LiveBeansView 的 ObjectName 的 domain
		System.setProperty(MBEAN_DOMAIN_PROPERTY_NAME, "com.github.chenqimiao");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		// 注册 Configuration Class
		context.register(LiveBeansViewDemo.class);

		// 启动 Spring 应用上下文
		context.refresh();

		System.out.println("按任意键继续...");

		System.in.read();

		context.close();
	}
}
