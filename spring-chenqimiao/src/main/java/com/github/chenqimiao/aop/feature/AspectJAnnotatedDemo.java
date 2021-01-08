package com.github.chenqimiao.aop.feature;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2021-01-08 14:59
 **/
@Configuration
@EnableAspectJAutoProxy
public class AspectJAnnotatedDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 不同Aspect的执行顺序跟@Order/Ordered 相关， 同一个Aspect的执行顺序有其固定的模式(如 @Around 优先于 @Before)
		context.register(AspectJAnnotatedDemo.class, AspectJConfiguration.class, AspectJConfiguration2.class);
		context.refresh();
		AspectJAnnotatedDemo demo = context.getBean(AspectJAnnotatedDemo.class);
		demo.execute();
	}

	public void execute(){
		System.out.println("execute ...");
	}
}
