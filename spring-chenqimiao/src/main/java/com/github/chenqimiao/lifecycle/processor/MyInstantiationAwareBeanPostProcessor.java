package com.github.chenqimiao.lifecycle.processor;

import com.github.chenqimiao.lifecycle.component.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/20 10:15
 * @Description:
 */
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName)
			throws BeansException {
		if("user".equals(beanName)){
			System.out.println("InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation");
		}
		//返回非null,会绕开后续的Bean实例化操作
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName)
			throws BeansException {
		if(bean instanceof User){
			User user = (User) bean;
			user.setName("V4");
			System.out.println("InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation, user.name = " + user.getName() );
		}
		//表示属性应该被设置到Bean实例
		return true;
	}
}
