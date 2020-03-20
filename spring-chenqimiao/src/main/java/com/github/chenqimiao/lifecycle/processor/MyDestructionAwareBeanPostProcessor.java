package com.github.chenqimiao.lifecycle.processor;

import com.github.chenqimiao.lifecycle.component.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/20 10:57
 * @Description:
 */
public class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {

	@Override
	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
		if(bean instanceof User){
			User user = (User) bean;
			user.setName("V21");
			System.out.println("DestructionAwareBeanPostProcessor#postProcessBeforeDestruction, user.name = " + user.getName());
		}
	}
}
