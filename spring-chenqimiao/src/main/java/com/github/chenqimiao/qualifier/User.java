package com.github.chenqimiao.qualifier;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/13 18:13
 * @Description:
 */
public class User {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				'}';
	}

	public User(Long id) {
		this.id = id;
	}
}
