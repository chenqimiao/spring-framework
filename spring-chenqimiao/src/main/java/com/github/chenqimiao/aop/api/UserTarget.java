package com.github.chenqimiao.aop.api;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/6 16:32
 * @Description:
 */
public class UserTarget implements User{

	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public void sayHello() {
		System.out.println("Hello, " + name);
	}
}
