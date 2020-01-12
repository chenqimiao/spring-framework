package com.github.chenqimiao.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;

/**
 * @Auther: chenqimiao
 * @Date: 2020/1/12 13:11
 * @Description:
 */
public class UserFactory implements ObjectFactory {

	@Override
	public User getObject() throws BeansException {
		return new User("Qimiao Chen", 18);
	}
}
