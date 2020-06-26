package com.github.chenqimiao.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-06-26 22:04
 **/
public class AsyncApplicationEventListenerByAPIDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac =
				new AnnotationConfigApplicationContext(AsyncApplicationEventListenerByAPIDemo.class);
		ac.addApplicationListener(new MyEventListener());
		ApplicationEventMulticaster multicaster =
				ac.getBean(AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME, ApplicationEventMulticaster.class);
		if(multicaster instanceof SimpleApplicationEventMulticaster) {
			SimpleApplicationEventMulticaster simpleApplicationEventMulticaster =
					(SimpleApplicationEventMulticaster) multicaster;
			ExecutorService taskExecutor = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("single-thread-pool-"));
			simpleApplicationEventMulticaster.setTaskExecutor(taskExecutor);
			ac.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
				@Override
				public void onApplicationEvent(ContextClosedEvent event) {
					// 优雅关闭
					System.out.println("优雅关闭 taskExecutor");
					taskExecutor.shutdown();
				}
			});
		}
		ac.publishEvent(new MyEvent(new Object()));
		ac.close();
	}

	@SuppressWarnings("serial")
	static class MyEvent extends ApplicationEvent {

		public MyEvent(Object source) {
			super(source);
		}
	}

	static class MyEventListener implements ApplicationListener<MyEvent>{

		@Override
		public void onApplicationEvent(MyEvent event) {
			System.out.printf("[线程]: %s 监听到事件 MyEvent \n", Thread.currentThread().getName());
		}
	}

}

