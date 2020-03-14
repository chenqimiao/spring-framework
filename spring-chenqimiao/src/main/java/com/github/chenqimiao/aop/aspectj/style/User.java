package com.github.chenqimiao.aop.aspectj.style;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/14 15:01
 * @Description:
 */
public class User implements BeanFactoryAware {

	public static BeanFactory beanFactory;

	public void advisedMethod(){
		System.out.println("AdvisedMethod join point");
		//throw new RuntimeException();
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		User.beanFactory = beanFactory;
	}
}
