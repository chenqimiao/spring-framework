package com.github.chenqimiao.aop.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-04-25 17:15
 **/
public class EventPublicationExecutor extends Executor implements ApplicationEventPublisherAware {


	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	public void execute() {
		super.execute();
		// 手动发布事件
		applicationEventPublisher.publishEvent(new ExecutedEvent(this));
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
}
