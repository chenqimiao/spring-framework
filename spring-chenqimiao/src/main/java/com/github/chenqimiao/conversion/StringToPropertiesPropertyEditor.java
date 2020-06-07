package com.github.chenqimiao.conversion;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map.Entry;
import java.util.Properties;

/**
 * @Auther: chenqimiao
 * @Date: 2020/5/21 16:53
 * @Description: Spring只会利用PropertyEditor，将String转化成指定类型,但其实PropertyEditor是支持将其他类型转化成String的。
 */
public class StringToPropertiesPropertyEditor extends PropertyEditorSupport implements PropertyEditor {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Properties properties = new Properties();
		try {
			properties.load(new StringReader(text));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//存储，通过 getValue 获取转化后的值
		setValue(properties);
	}

	@Override
	public String getAsText() {
		Properties properties = (Properties) getValue();
		StringBuilder textBuilder = new StringBuilder();
		for (Entry<Object, Object> entry : properties.entrySet()){
			textBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append(System.getProperty("line.separator"));
		}
		return textBuilder.toString();

	}
}
