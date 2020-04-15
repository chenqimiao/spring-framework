package com.github.chenqimiao.circular.reference;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2020/4/15 10:09
 * @Description:
 */
@Component
public class HusbandFactoryBean implements FactoryBean<Husband>, BeanFactoryAware {

	private BeanFactory beanFactory;

	@Override
	public Husband getObject() throws Exception {
		Husband husband = new Husband();
		Wife wife = beanFactory.getBean(Wife.class);
		husband.setWife(wife);
		return husband;
	}

	@Override
	public Class<?> getObjectType() {
		return Husband.class;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
}
