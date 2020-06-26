package com.github.chenqimiao.event;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description: early application event demo
 * @Author: Qimiao Chen
 * @Create: 2020-06-26 21:17
 **/
public class EarlyApplicationEventDemo implements ApplicationEventPublisherAware, BeanPostProcessor {



	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		applicationEventPublisher.publishEvent(new MyEvent(this));
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.register(EarlyApplicationEventDemo.class);
		ac.addApplicationListener(new MyListener());
		ac.refresh();
	}


}

@SuppressWarnings("serial")
class MyEvent extends ApplicationEvent {

	public MyEvent(Object source) {
		super(source);
	}
}

class MyListener implements ApplicationListener<MyEvent>{

	@Override
	public void onApplicationEvent(MyEvent event) {
		System.out.println("on MyEvent ");
	}
}
