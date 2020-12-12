package com.github.chenqimiao.aop.overview;

/**
 * @Description: 静态代理示例
 * @Author: Qimiao Chen
 * @Create: 2020-12-12 17:27
 **/
public class StaticProxyDemo {

	public static void main(String[] args) {
		ProxyEchoService proxyEchoService = new ProxyEchoService(new DefaultEchoService());
		proxyEchoService.echo("Hello, Qimiao Chen");
	}
}
