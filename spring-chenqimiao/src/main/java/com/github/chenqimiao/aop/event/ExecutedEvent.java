package com.github.chenqimiao.aop.event;

import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-04-25 17:18
 **/
public class ExecutedEvent extends ApplicationEvent implements Serializable {


	private static final long serialVersionUID = 8697030364171804924L;

	/**
	 * Create a new {@code ApplicationEvent}.
	 *
	 * @param source the object on which the event initially occurred or with
	 *               which the event is associated (never {@code null})
	 */
	public ExecutedEvent(Object source) {
		super(source);
	}
}
