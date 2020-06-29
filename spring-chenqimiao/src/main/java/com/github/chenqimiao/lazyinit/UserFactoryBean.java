package com.github.chenqimiao.lazyinit;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-06-29 10:31
 **/
public class UserFactoryBean implements FactoryBean<User> {

	@Override
	public User getObject() throws Exception {
		return new User("chenqimiao");
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
