package com.github.chenqimiao.lazyinit;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-06-29 10:31
 **/
public class User {

	private String name;

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				'}';
	}
}
