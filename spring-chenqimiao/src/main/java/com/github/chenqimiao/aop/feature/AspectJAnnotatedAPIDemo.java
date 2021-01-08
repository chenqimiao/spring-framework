package com.github.chenqimiao.aop.feature;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-12-31 15:08
 **/
public class AspectJAnnotatedAPIDemo {
	public static void main(String[] args) {
		AspectJAnnotatedAPIDemo aspectJAnnotatedAPIDemo = new AspectJAnnotatedAPIDemo();

		AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(aspectJAnnotatedAPIDemo);

		aspectJProxyFactory.addAspect(AspectJConfiguration.class);

		AspectJAnnotatedAPIDemo proxy = aspectJProxyFactory.getProxy();

		proxy.execute();

	}

	public void execute(){
		System.out.println("execute() ...");
	}
}
