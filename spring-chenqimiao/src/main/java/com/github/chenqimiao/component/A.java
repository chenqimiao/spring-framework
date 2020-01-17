package com.github.chenqimiao.component;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/7 15:23
 * @Description:
 */
//@Component
//@Scope("singleton")
public class A implements BAware{

	//@Autowired
	private B b;


	public void setB(B b) {
		this.b = b;
	}

	public B getB() {
		return b;
	}


	public A (){
		System.out.println("Call A Constructor ");
	}

}
