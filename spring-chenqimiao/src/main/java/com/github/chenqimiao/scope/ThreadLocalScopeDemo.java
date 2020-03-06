package com.github.chenqimiao.scope;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/6 10:22
 * @Description: 自定义Scope示例
 */
@Configuration
public class ThreadLocalScopeDemo {

	@Bean
	@Scope(scopeName = ThreadLocalScope.SCOPE_NAME)
	public User user(){
		return new User();
	}

	public static void main(String args[]){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.getBeanFactory().registerScope(ThreadLocalScope.SCOPE_NAME, new ThreadLocalScope());
		ac.register(ThreadLocalScopeDemo.class);
		ac.refresh();
		loopUpScopedBean(ac);
		loopUpScopedBeanWithMultiThread(ac);

	}

	private static void loopUpScopedBeanWithMultiThread(BeanFactory factory) {
		for (int i = 0; i < 3 ;i++){
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					User user = factory.getBean("user", User.class);
					System.out.println(user);
				}
			});
			thread.start();
		}
	}

	private static void loopUpScopedBean(BeanFactory factory) {

		for (int i = 0; i < 3 ;i++){
			User user = factory.getBean("user", User.class);
			System.out.println(user);
		}
	}
}
