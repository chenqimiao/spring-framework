package com.github.chenqimiao.generic;

import org.springframework.core.ResolvableType;

/**
 * @Description: ResolvableType demo
 * @Author: Qimiao Chen
 * @Create: 2020-06-13 15:41
 **/
public class ResolvableTypeDemo {

	private StringList stringList;

	public static void main(String[] args) throws NoSuchFieldException {
		ResolvableType resolvableType = ResolvableType.forField(
				ResolvableTypeDemo.class.getDeclaredField("stringList"));
		// String
		System.out.println(resolvableType.getSuperType().resolveGeneric(0));
		System.out.println(resolvableType.asCollection().resolveGeneric(0));
	}
}
