package com.github.chenqimiao.lifecycle.application;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @Description: Lifecycle Bean  示例
 * @Author: Qimiao Chen
 * @Create: 2020-08-01 11:11
 **/
@Configuration
public class LifecycleDemo {

	public static void main(String[] args) {

		GenericApplicationContext context = new GenericApplicationContext();

		context.registerBeanDefinition("myLifecycle", BeanDefinitionBuilder.genericBeanDefinition(MyLifecycle.class).getBeanDefinition());

		// 刷新应用上下文
		context.refresh();

		// 启动应用上下文
		context.start();

		// 停止应用上下文
		context.stop();

		// 关闭应用上下文
		context.close();
	}
}
