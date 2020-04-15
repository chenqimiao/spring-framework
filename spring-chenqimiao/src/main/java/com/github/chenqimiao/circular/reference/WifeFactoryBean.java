package com.github.chenqimiao.circular.reference;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2020/4/15 10:20
 * @Description:
 */
@Component
public class WifeFactoryBean implements FactoryBean<Wife>, BeanFactoryAware {

	private BeanFactory beanFactory;

	@Override
	public Wife getObject() throws Exception {
		Wife wife = new Wife();
		Husband husband = beanFactory.getBean(Husband.class);
		wife.setHusband(husband);
		return wife;
	}

	@Override
	public Class<?> getObjectType() {
		return Wife.class;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
}
