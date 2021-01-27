package com.github.chenqimiao.aop.feature.pointcut;

import com.github.chenqimiao.aop.overview.DefaultEchoService;
import com.github.chenqimiao.aop.overview.EchoService;
import org.springframework.aop.*;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.*;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-01-27 14:50
 **/
public class PointcutAPIDemo {

	public static void main(String[] args) {


		ComposablePointcut composablePointcut = new ComposablePointcut(EchoServiceStaticMethodMatcherPointcut.INSTANCE);

		String[] patterns = {"[a-zA-Z.]+\\.echo"};
		JdkRegexpMethodPointcut jdkRegexpMethodPointcut = new JdkRegexpMethodPointcut();
		jdkRegexpMethodPointcut.setPatterns(patterns);
		composablePointcut.intersection((Pointcut) jdkRegexpMethodPointcut);

		Pointcut controlFlowPointcut = new ControlFlowPointcut(PointcutAPIDemo.class, "main");
		composablePointcut.intersection(controlFlowPointcut);

		composablePointcut.intersection(new ClassFilter() {
			@Override
			public boolean matches(Class<?> clazz) {
				return true;
			}
		});
		composablePointcut.intersection(new MethodMatcher() {
			@Override
			public boolean matches(Method method, Class<?> targetClass) {
				return true;
			}

			@Override
			public boolean isRuntime() {
				return true;
			}

			@Override
			public boolean matches(Method method, Class<?> targetClass, Object... args) {
				return true;
			}
		});


		Advisor advisor = new DefaultPointcutAdvisor(composablePointcut, new MethodBeforeAdvice() {
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.println(method.getName() + " 方法被增强!");
			}
		});
		ProxyFactory proxyFactory = new ProxyFactory(new DefaultEchoService());
		proxyFactory.addAdvisor(advisor);
		EchoService echoService = (EchoService)proxyFactory.getProxy();
		echoService.echo("Hello, Qimiao Chen");
	}
}
