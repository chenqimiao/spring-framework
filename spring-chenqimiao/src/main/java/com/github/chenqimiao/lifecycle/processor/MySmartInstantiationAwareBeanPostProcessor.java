package com.github.chenqimiao.lifecycle.processor;

import java.lang.reflect.Constructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/23 22:32
 * @Description:
 */
public class MySmartInstantiationAwareBeanPostProcessor implements
		SmartInstantiationAwareBeanPostProcessor {

	@Override
	public Constructor<?>[] determineCandidateConstructors(
			Class<?> beanClass, String beanName) throws BeansException {
		//用以决定构造器候选人
		System.out.println("SmartInstantiationAwareBeanPostProcessor#determineCandidateConstructors");
		return null;
	}
}
