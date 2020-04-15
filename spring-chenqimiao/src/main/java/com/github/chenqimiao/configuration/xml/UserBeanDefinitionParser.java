package com.github.chenqimiao.configuration.xml;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @Auther: chenqimiao
 * @Date: 2020/4/4 00:57
 * @Description:
 */
public class UserBeanDefinitionParser extends AbstractSimpleBeanDefinitionParser {


	@Override
	protected void doParse(Element element,
			ParserContext parserContext,
			BeanDefinitionBuilder builder) {

		setPropertyValue("name", element, builder);
		setPropertyValue("age", element, builder);
	}

	private void setPropertyValue(String attrName, Element element, BeanDefinitionBuilder beanDefinitionBuilder){
		String attrVal = element.getAttribute(attrName);
		beanDefinitionBuilder.addPropertyValue(attrName, attrVal);
	}
	@Override
	protected Class<?> getBeanClass(Element element) {
		return User.class;
	}

}
