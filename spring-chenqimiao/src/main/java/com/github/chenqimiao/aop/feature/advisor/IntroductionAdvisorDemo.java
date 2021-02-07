package com.github.chenqimiao.aop.feature.advisor;

import com.github.chenqimiao.aop.overview.EchoService;
import org.springframework.aop.IntroductionInfo;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Description: IntroductionAdvisor 实例
 * @Author: Qimiao Chen
 * @Create: 2021-02-07 13:20
 **/
public class IntroductionAdvisorDemo implements EchoService, Comparable<IntroductionAdvisorDemo> {

	public static void main(String[] args) {

		IntroductionAdvisorDemo target = new IntroductionAdvisorDemo();

		// 会将所有实现接口作为代理接口
		// ProxyFactory proxyFactory = new ProxyFactory(target);

		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvisor(new DefaultIntroductionAdvisor(new MethodBeforeAdvice() {
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println("BeforeAdvice : " + method);
			}
		},  new IntroductionInfo(){
			@Override
			public Class<?>[] getInterfaces() {
				// 可以限制和扩展一些接口
				return new Class<?>[]{EchoService.class, Map.class};
			}
		}));

		Object proxy = proxyFactory.getProxy();

		EchoService echoService = (EchoService) proxy;
		echoService.echo("Hello, Qimiao chen");

		//  AOP configuration seems to be invalid: tried calling method [public abstract java.lang.Object java.util.Map.put
		Map<?,?> map = (Map<?, ?>) proxy;
		map.put(null, null);

		// $Proxy0 cannot be cast to class java.lang.Comparable
		Comparable<?> comparable = (Comparable<?>) proxy;
		comparable.compareTo(null);


	}

	@Override
	public String echo(String message) throws NullPointerException {
		return "IntroductionAdvisorDemo : " + message;
	}

	@Override
	public int compareTo(IntroductionAdvisorDemo o) {
		return 0;
	}
}
