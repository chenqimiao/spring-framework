package com.github.chenqimiao.lazyinit;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-06-29 16:44
 **/
public class MyEventListener {

	@EventListener
	public void onApplication(ApplicationEvent event) {
		System.out.printf("MyEventListener#onApplication %s \n", event);
	}
}
