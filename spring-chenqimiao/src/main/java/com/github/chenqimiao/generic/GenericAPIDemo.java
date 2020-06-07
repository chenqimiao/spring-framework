package com.github.chenqimiao.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

/**
 * @Auther: chenqimiao
 * @Date: 2020/6/7 18:55
 * @Description: Java 原生泛型 API 演示
 */
public class GenericAPIDemo {

	public static void main(String[] args) {

		// primitive class
		Class intClass = int.class;

		// array class
		Class arrayClass = Object[].class;

		// raw class
		Class rawClass = String.class;

		// parameterizedType
		ParameterizedType parameterizedType = (ParameterizedType) ArrayList.class.getGenericSuperclass();

		// raw type
		Type rawType = parameterizedType.getRawType();

		// TypeVariable[]
		Type[] types = parameterizedType.getActualTypeArguments();

		// TypeVariable
		TypeVariable typeVariable = (TypeVariable) types[0];


	}
}
