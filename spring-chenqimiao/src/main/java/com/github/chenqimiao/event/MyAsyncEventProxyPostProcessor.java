package com.github.chenqimiao.event;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.BeansException;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/26 15:24
 * @Description:
 */
@SuppressWarnings("serial")
public class MyAsyncEventProxyPostProcessor extends AbstractAutoProxyCreator {

	@Override
	protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName,
			TargetSource customTargetSource) throws BeansException {
		return new Object[0];
	}
}
