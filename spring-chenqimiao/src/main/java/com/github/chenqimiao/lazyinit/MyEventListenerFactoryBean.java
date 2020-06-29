package com.github.chenqimiao.lazyinit;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-06-29 16:44
 **/
public class MyEventListenerFactoryBean implements FactoryBean<MyEventListener> {
	@Override
	public MyEventListener getObject() throws Exception {
		return new MyEventListener();
	}

	@Override
	public Class<?> getObjectType() {
		return MyEventListener.class;
	}
}
