package com.github.chenqimiao.lifecycle.processor;

import com.github.chenqimiao.lifecycle.component.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/20 10:38
 * @Description:
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		if(bean instanceof User){
			User user = (User)bean;
			user.setName("V9");
			System.out.println("BeanPostProcessor#postProcessBeforeInitialization, user.name = " + user.getName());
		}
		//返回null会造成后续的BeanPostProcessor#postProcessBeforeInitialization不再执行
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		if(bean instanceof User){
			User user = (User)bean;
			user.setName("V19");
			System.out.println("BeanPostProcessor#postProcessAfterInitialization, user.name = " + user.getName());
		}
		//返回null会造成后续的BeanPostProcessor#postProcessAfterInitialization不再执行
		return bean;
	}
}
