package com.github.chenqimiao.configuration.postprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/25 01:13
 * @Description:
 */

@Component
@Import(OtherBean.class)
public class BeanPostProcessorInConfiguration {

	@Autowired
	public OtherBean otherBean;

	@Bean
	//是否会导致失效@Autowired失效与MyBeanPostProcessor定义的优先级有关系
	public MyBeanPostProcessor beanPostProcessor(){
		return new MyBeanPostProcessor();
	}

	@Bean
	//定义为static，不会导致外部配置类过早初始化，进而使得@Autowired失效
	public static MyBeanFactoryPostProcessor beanFactoryPostProcessor(){
		return new MyBeanFactoryPostProcessor();
	}

	public static void main(String args[]){
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanPostProcessorInConfiguration.class);
		System.out.println(ac.getBean(BeanPostProcessorInConfiguration.class).otherBean);

	}

}
