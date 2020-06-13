package com.github.chenqimiao.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import org.springframework.core.GenericTypeResolver;

/**
 * @Auther: chenqimiao
 * @Date: 2020/6/7 19:35
 * @Description: Spring GenericTypeResolver 解析泛型演示
 */
public class GenericTypeResolverDemo {

	public static void main(String[] args) throws NoSuchMethodException {

		displayReturnTypeGenericInfo(GenericTypeResolverDemo.class, Comparable.class, "getString");

		displayReturnTypeGenericInfo(GenericTypeResolverDemo.class, ArrayList.class, "getStringList");

		displayReturnTypeGenericInfo(GenericTypeResolverDemo.class, ArrayList.class, "getObjectList");

	}

	public String getString(){
		return null;
	}

	public StringList getStringList(){
		return null;
	}

	public ArrayList<Object> getObjectList(){
		return null;
	}


	public static void displayReturnTypeGenericInfo(Class<?> containingClass, Class<?> genericInfoClass,
			String methodName, Class<?> ... argumentTypes) throws NoSuchMethodException {

		Method method = containingClass.getMethod(methodName, argumentTypes);

		Class<?> returnType = GenericTypeResolver.resolveReturnType(method, containingClass);

		System.out.printf("GenericTypeResolver.resolveReturnType(%s, %s) = %s\n", method.getName(),
				containingClass.getSimpleName(), returnType);

		Class<?> returnTypeArgument = GenericTypeResolver.resolveReturnTypeArgument(method, genericInfoClass);

		System.out.printf("GenericTypeResolver.resolveReturnTypeArgument(%s, %s) = %s\n", method.getName(),
				genericInfoClass.getSimpleName(), returnTypeArgument);


	}

}

