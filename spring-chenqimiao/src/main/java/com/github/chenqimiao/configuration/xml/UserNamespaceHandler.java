package com.github.chenqimiao.configuration.xml;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Auther: chenqimiao
 * @Date: 2020/4/4 00:54
 * @Description:
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
	}
}
