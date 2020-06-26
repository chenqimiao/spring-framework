package com.github.chenqimiao.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.util.ErrorHandler;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-06-26 23:02
 **/
public class ErrorHandlerDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

		ac.register(ErrorHandlerDemo.class);

		ac.refresh();

		ac.addApplicationListener(new ApplicationListener<MyEvent>() {
			@Override
			public void onApplicationEvent(MyEvent event) {
				System.out.println(event);
				throw new RuntimeException("故意抛出异常");
			}
		});

		ApplicationEventMulticaster multicaster =
				ac.getBean(AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME, ApplicationEventMulticaster.class);
		if(multicaster instanceof SimpleApplicationEventMulticaster) {
			SimpleApplicationEventMulticaster simpleApplicationEventMulticaster =
					(SimpleApplicationEventMulticaster) multicaster;
			simpleApplicationEventMulticaster.setErrorHandler(new ErrorHandler() {
				@Override
				public void handleError(Throwable t) {
					System.out.println("事件处理被终止的原因 ： " + t.getMessage());
					//throw (RuntimeException) t;
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
}
