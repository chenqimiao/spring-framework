package com.github.chenqimiao.configuration.yaml;

import java.util.Map;
import java.util.Properties;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @Auther: chenqimiao
 * @Date: 2020/4/4 11:41
 * @Description:
 */
@Configuration(proxyBeanMethods = false)
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:/META-INF/yaml/user-config.yaml", name = "yamlBasedPropertySource")
public class YamlBasedConfigurationDemo {

	@Bean
	public YamlMapFactoryBean user(){
		YamlMapFactoryBean yamlMapFactoryBean = new YamlMapFactoryBean();
		Resource resource = new ClassPathResource("META-INF/yaml/user-config.yaml");
		yamlMapFactoryBean.setResources(resource);
		return yamlMapFactoryBean;
	}
	@Bean
	public YamlPropertiesFactoryBean user1(){
		YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
		Resource resource = new ClassPathResource("META-INF/yaml/user-config.yaml");
		yamlPropertiesFactoryBean.setResources(resource);
		return yamlPropertiesFactoryBean;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
				YamlBasedConfigurationDemo.class);
		Map<String, Object> yamlMap = ac.getBean("user", Map.class);
		System.out.println(yamlMap);

		Properties properties = ac.getBean("user1", Properties.class);
		System.out.println(properties);

		MutablePropertySources propertySources = ac.getEnvironment().getPropertySources();
		System.out.println(propertySources);

		System.out.println(propertySources.get("yamlBasedPropertySource").getProperty("user.name"));
	}
}
