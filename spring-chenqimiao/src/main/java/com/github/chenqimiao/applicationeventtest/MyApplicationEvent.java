package com.github.chenqimiao.applicationeventtest;

import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/25 20:26
 * @Description:
 */
public class MyApplicationEvent {
	private String name;

	public MyApplicationEvent(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
