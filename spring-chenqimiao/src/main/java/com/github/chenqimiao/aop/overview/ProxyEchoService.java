package com.github.chenqimiao.aop.overview;

/**
 * @Description: 静态代理
 * @Author: Qimiao Chen
 * @Create: 2020-12-12 17:24
 **/
public class ProxyEchoService implements EchoService{

	private EchoService echoService;

	public ProxyEchoService(EchoService echoService) {
		this.echoService = echoService;
	}

	@Override
	public String echo(String message) {
		long startTime = System.currentTimeMillis();
		String result = echoService.echo(message);
		long costTime = System.currentTimeMillis() - startTime;
		System.out.println("执行 echo 方法需要 " + costTime + " ms.");
		return result;
	}
}
