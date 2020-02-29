package com.github.chenqimiao.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/25 20:26
 * @Description:
 */
@Component
public class MyApplicationEventListener {


	@EventListener
	//@Async
	public MyOtherApplicationEvent onMyApplicationEventListener(MyApplicationEvent event){
		System.out.println("onMyApplicationEventListener name=" + event.getName());
		return new MyOtherApplicationEvent("MyOtherApplicationEvent from MyApplicationEventListener ");
	}
}
