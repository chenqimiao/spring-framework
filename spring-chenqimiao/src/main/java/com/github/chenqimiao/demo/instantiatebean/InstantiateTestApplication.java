package com.github.chenqimiao.demo.instantiatebean;

import com.github.chenqimiao.component.UserService;
import java.util.ServiceLoader;
import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Auther: chenqimiao
 * @Date: 2020/1/17 09:31
 * @Description:
 */
@SuppressWarnings("unchecked")
public class InstantiateTestApplication {

	public static void main(String[] args) throws Exception {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		//ServiceLoader的方式
		BeanDefinitionBuilder serviceLoaderBuilder = BeanDefinitionBuilder.genericBeanDefinition(
				ServiceLoaderFactoryBean.class);
		serviceLoaderBuilder.addPropertyValue("serviceType", UserService.class);


		beanFactory.registerBeanDefinition("userServiceServiceLoader",serviceLoaderBuilder.getBeanDefinition());

		ServiceLoader<UserService> serviceLoader = beanFactory.getBean("userServiceServiceLoader",ServiceLoader.class);

		UserService userService = serviceLoader.iterator().next();

		//直接通过AutowireCapableBeanFactory#createBean进行实例化
//		AutowireCapableBeanFactory autowireCapableBeanFactory = (DefaultListableBeanFactory)beanFactory;
//		UserService userService = autowireCapableBeanFactory.createBean(UserServiceImpl.class);

	}

}
