package com.github.chenqimiao.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 环境属性源变更
 * @Author: Qimiao Chen
 * @Create: 2020-07-18 15:40
 **/
public class EnvironmentPropertySourceChangeDemo {

	@Value("${user.name}")
	private String username;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

		// 注册 Configuration Class
		ac.register(EnvironmentPropertySourceChangeDemo.class);

		ConfigurableEnvironment environment = ac.getEnvironment();

		MutablePropertySources propertySources = environment.getPropertySources();

		Map<String, Object> source = new HashMap<>();

		source.put("user.name", "陈其苗");

		MapPropertySource propertySource = new MapPropertySource("first-property-source", source);

		propertySources.addFirst(propertySource);

		ac.refresh();

		EnvironmentPropertySourceChangeDemo demo = ac.getBean(EnvironmentPropertySourceChangeDemo.class);

		System.out.println(demo.username); // "陈其苗"

		source.put("user.name", "chenqimiao");

		System.out.println(demo.username); // "陈其苗"

		for (PropertySource<?> ps : propertySources) {
			System.out.printf("PropertySource(name=%s) 'user.name' 属性：%s\n", ps.getName(), ps.getProperty("user.name"));
		}


	}
}
