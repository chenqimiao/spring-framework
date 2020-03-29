package com.github.chenqimiao.conditional;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/29 16:09
 * @Description:
 */
public class NoConfigurationThreeCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context,
			AnnotatedTypeMetadata metadata) {
		return !context.getBeanFactory().containsBeanDefinition("configuration3") ;
	}
}
