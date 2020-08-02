package com.github.chenqimiao.lifecycle.application;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.support.GenericApplicationContext;

import java.io.IOException;

/**
 * @Description: SpringShutdownHook Demo
 * @Author: Qimiao Chen
 * @Create: 2020-08-02 11:48
 **/
public class SpringShutdownHookThreadDemo {
	public static void main(String[] args) throws IOException {

		GenericApplicationContext context = new GenericApplicationContext();

		context.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
			@Override
			public void onApplicationEvent(ContextClosedEvent event) {
				System.out.printf("[线程 %s] ContextClosedEvent 处理\n", Thread.currentThread().getName());
			}
		});

		// jvm 层面注册一个 webhook
		context.registerShutdownHook();

		context.refresh();

		System.out.println("按任意键继续...");

		System.in.read();


	}
}
