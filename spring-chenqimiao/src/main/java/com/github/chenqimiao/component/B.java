package com.github.chenqimiao.component;

import javax.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.SmartLifecycle;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/7 15:24
 * @Description:
 */
//@Component
//@Scope("prototype")
public class B implements DisposableBean, SmartLifecycle {


	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean.destroy");
	}

	@PreDestroy
	public void destroy1(){
		System.out.println("@PreDestroy");
	}

	public void destroy2(){
		System.out.println("@Bean destroyMethod");
	}

	@Override
	public void start() {
		System.out.println("start");
	}

	@Override
	public void stop() {
		System.out.println("stop");

	}

	@Override
	public boolean isRunning() {
		return true;
	}
}
