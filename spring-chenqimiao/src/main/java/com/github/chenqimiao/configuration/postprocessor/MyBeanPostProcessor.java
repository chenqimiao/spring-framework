package com.github.chenqimiao.configuration.postprocessor;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/25 01:14
 * @Description:
 */
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered , PriorityOrdered {

	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}
}
