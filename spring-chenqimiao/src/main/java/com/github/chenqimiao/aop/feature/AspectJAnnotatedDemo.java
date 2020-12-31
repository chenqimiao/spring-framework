package com.github.chenqimiao.aop.feature;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-12-31 15:08
 **/
public class AspectJAnnotatedDemo {
	public static void main(String[] args) {
		AspectJAnnotatedDemo aspectJAnnotatedDemo = new AspectJAnnotatedDemo();

		AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(aspectJAnnotatedDemo);

		aspectJProxyFactory.addAspect(AspectJConfiguration.class);

		AspectJAnnotatedDemo proxy = aspectJProxyFactory.getProxy();

		proxy.execute();

	}

	public void execute(){
		System.out.println("execute() ...");
	}
}
