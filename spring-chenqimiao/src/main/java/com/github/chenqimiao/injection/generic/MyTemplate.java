package com.github.chenqimiao.injection.generic;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-07-25 19:07
 **/
public class MyTemplate<K,V> {

	private String name;

	public MyTemplate(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyTemplate{" +
				"name='" + name + '\'' +
				'}';
	}
}
