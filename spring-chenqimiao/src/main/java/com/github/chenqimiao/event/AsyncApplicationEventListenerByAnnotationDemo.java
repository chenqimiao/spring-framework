package com.github.chenqimiao.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-06-26 22:38
 **/
@EnableAsync
@Configuration
public class AsyncApplicationEventListenerByAnnotationDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac =
				new AnnotationConfigApplicationContext();
		ac.register(AsyncApplicationEventListenerByAnnotationDemo.class, MyEventListener.class);
		ac.refresh();
		ac.publishEvent(new MyEvent(new Object()));
		ac.close();
	}

	@SuppressWarnings("serial")
	static class MyEvent extends ApplicationEvent {

		public MyEvent(Object source) {
			super(source);
		}
	}

	@Async
	static class MyEventListener {

		@EventListener
		public void onApplicationEvent(MyEvent event) {
			System.out.printf("[线程]: %s 监听到事件 MyEvent \n", Thread.currentThread().getName());
		}
	}

}
