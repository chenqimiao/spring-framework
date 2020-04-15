package com.github.chenqimiao.circular.reference;

import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2020/4/15 10:08
 * @Description:
 */
public class Wife {

	private Husband husband;

	public Husband getHusband() {
		return husband;
	}

	public void setHusband(Husband husband) {
		this.husband = husband;
	}
}
