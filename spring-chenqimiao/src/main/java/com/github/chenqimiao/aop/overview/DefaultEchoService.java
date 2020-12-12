package com.github.chenqimiao.aop.overview;

/**
 * @Description: 默认的 EchoService 实现
 * @Author: Qimiao Chen
 * @Create: 2020-12-12 17:23
 **/
public class DefaultEchoService implements EchoService{
	@Override
	public String echo(String message) {
		return message;
	}
}
