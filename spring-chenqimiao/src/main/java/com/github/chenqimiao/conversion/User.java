package com.github.chenqimiao.conversion;

import java.util.Properties;

/**
 * @Auther: chenqimiao
 * @Date: 2020/5/29 14:03
 * @Description:
 */
public class User {

	private Properties context;

	private String contextAsString;

	public Properties getContext() {
		return context;
	}

	public void setContext(Properties context) {
		this.context = context;
	}

	public String getContextAsString() {
		return contextAsString;
	}

	public void setContextAsString(String contextAsString) {
		this.contextAsString = contextAsString;
	}

	@Override
	public String toString() {
		return "User{" +
				"context=" + context +
				", contextAsString='" + contextAsString + '\'' +
				'}';
	}
}
