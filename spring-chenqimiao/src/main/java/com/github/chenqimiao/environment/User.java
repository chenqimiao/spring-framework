package com.github.chenqimiao.environment;

/**
 * @Description: 测试类
 * @Author: Qimiao Chen
 * @Create: 2020-07-11 11:41
 **/

public class User {

	private String name;

	private String city;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", city='" + city + '\'' +
				'}';
	}
}
