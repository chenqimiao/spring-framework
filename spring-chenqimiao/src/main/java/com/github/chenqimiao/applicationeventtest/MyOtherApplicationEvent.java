package com.github.chenqimiao.applicationeventtest;

import org.springframework.context.ApplicationEvent;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/25 22:28
 * @Description:
 */
public class MyOtherApplicationEvent extends ApplicationEvent {
	private String name;

	public MyOtherApplicationEvent(String name) {
		super("MyOtherApplicationEvent");
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
