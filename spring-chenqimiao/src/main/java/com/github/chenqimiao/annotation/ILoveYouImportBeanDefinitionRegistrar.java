package com.github.chenqimiao.annotation;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Description:
 * @Author: Qimiao Chen
 * @Create: 2020-07-09 20:45
 **/
public class ILoveYouImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		BeanDefinitionBuilder bdb = BeanDefinitionBuilder.genericBeanDefinition(ILoveYouConfiguration.class);
		AbstractBeanDefinition beanDefinition = bdb.getBeanDefinition();
		BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
	}
}
