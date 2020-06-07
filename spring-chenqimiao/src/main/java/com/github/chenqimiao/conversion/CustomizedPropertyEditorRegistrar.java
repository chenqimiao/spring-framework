package com.github.chenqimiao.conversion;

import java.util.Properties;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

/**
 * @Auther: chenqimiao
 * @Date: 2020/5/29 14:01
 * @Description:
 */
public class CustomizedPropertyEditorRegistrar implements PropertyEditorRegistrar {

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Properties.class, new StringToPropertiesPropertyEditor());
	}
}
