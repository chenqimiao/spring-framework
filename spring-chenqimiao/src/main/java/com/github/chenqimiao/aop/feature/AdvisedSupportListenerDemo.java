package com.github.chenqimiao.aop.feature;


import com.github.chenqimiao.aop.api.MyAdvisor;
import com.github.chenqimiao.aop.overview.DefaultEchoService;
import com.github.chenqimiao.aop.overview.EchoService;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AdvisedSupportListener;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @Description: {@link org.springframework.aop.framework.AdvisedSupportListener} 示例
 * @Author: Qimiao Chen
 * @Create: 2021-02-20 17:25
 **/
public class AdvisedSupportListenerDemo {

	public static void main(String[] args) {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new DefaultEchoService());
		proxyFactory.addListener(new AdvisedSupportListener() {
			@Override
			public void activated(AdvisedSupport advised) {
				System.out.printf("AOP [%s] activated", advised);
			}

			@Override
			public void adviceChanged(AdvisedSupport advised) {
				System.out.printf("AOP [%s] adviceChanged", advised);
			}
		});

		// 触发 activated
		EchoService proxy = (EchoService)proxyFactory.getProxy();
		proxy.echo("Hello, Qimiao Chen");

		// 触发 adviceChanged
		proxyFactory.addAdvisor(new MyAdvisor());
	}

}
