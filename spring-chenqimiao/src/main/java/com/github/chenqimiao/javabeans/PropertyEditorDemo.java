package com.github.chenqimiao.javabeans;

/**
 * @Auther: chenqimiao
 * @Date: 2020/5/21 17:13
 * @Description:
 */
public class PropertyEditorDemo {

	public static void main(String[] args) {
		String text = "name=chenqimiao";
		StringToPropertiesPropertyEditor stppe = new StringToPropertiesPropertyEditor();
		stppe.setAsText(text);
		System.out.println("getValue: " + stppe.getValue());
		System.out.println("getAsText: " + stppe.getAsText());
	}
}
