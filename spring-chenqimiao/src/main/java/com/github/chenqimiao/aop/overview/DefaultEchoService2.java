package com.github.chenqimiao.aop.overview;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-01-19 14:51
 **/
public class DefaultEchoService2 implements EchoService{
	@Override
	public String echo(String message) {
		return message;
	}
}
