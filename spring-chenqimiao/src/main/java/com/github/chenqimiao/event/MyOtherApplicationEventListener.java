package com.github.chenqimiao.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/25 22:28
 * @Description:
 */
@Component
public class MyOtherApplicationEventListener implements ApplicationListener<MyOtherApplicationEvent> {

	@Override
	public void onApplicationEvent(MyOtherApplicationEvent event) {
		System.out.println("MyOtherApplicationEventListener name=" + event.getName());
	}
}
