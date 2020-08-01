package com.github.chenqimiao.lifecycle.application;

import org.springframework.context.Lifecycle;

/**
 * @Description: 自定义Lifecycle 实现
 * @Author: Qimiao Chen
 * @Create: 2020-08-01 15:25
 **/
public class MyLifecycle implements Lifecycle {

	private boolean running = false;

	@Override
	public void start() {
		this.running = true;
		System.out.println("MyLifecycle 启动...");
	}

	@Override
	public void stop() {
		this.running = false;
		System.out.println("MyLifecycle 停止...");
	}

	@Override
	public boolean isRunning() {
		return this.running;
	}
}
