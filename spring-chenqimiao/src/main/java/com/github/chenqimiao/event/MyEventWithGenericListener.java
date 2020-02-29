package com.github.chenqimiao.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/26 16:14
 * @Description:
 */
@Component
public class MyEventWithGenericListener  {


	@EventListener
	public void onApplication(MyEventWithGeneric<String> eventWithGeneric){
		System.out.println("MyEventWithGenericListener.....");
	}
}
