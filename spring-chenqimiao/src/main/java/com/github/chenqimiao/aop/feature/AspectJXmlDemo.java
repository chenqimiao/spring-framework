package com.github.chenqimiao.aop.feature;

import com.github.chenqimiao.aop.overview.EchoService;
import org.springframework.aop.scope.ScopedObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-12-31 15:51
 **/
public class AspectJXmlDemo {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/aop/aspectj.xml");
		AspectJXmlDemo aspectJXmlDemo = context.getBean(AspectJXmlDemo.class);
		aspectJXmlDemo.execute();
		EchoService echoService = (EchoService)context.getBean("echoService");
		echoService.echo("Hello, Qimiao Chen");

		ScopedObject scopedObject = (ScopedObject) echoService;
		Object targetObject = scopedObject.getTargetObject();
		System.out.println("echoService: " + echoService + ", targetObject" + targetObject);



	}

	public String execute(){
		System.out.println("execute() ...");
		return "execute()";
	}
}
