package com.github.chenqimiao.aop.utils;

import com.github.chenqimiao.aop.overview.DefaultEchoService;
import com.github.chenqimiao.aop.overview.EchoService;
import org.springframework.aop.support.AopUtils;

import java.lang.reflect.Method;

/**
 * @Description: AopUtils demo
 * @Author: Qimiao Chen
 * @Create: 2021-03-04 20:10
 **/
public class AopUtilsDemo {

	public static void main(String[] args) throws NoSuchMethodException {
		Class<?> target = EchoService.class;
		Method method = DefaultEchoService.class.getDeclaredMethod("echo", String.class);
		Method selectedMethod = AopUtils.selectInvocableMethod(method, target);
		System.out.println("method == selectedMethod ? " + method.equals(selectedMethod));


		Method mostSpecificMethod = AopUtils.getMostSpecificMethod(method, target);
		System.out.println("method == mostSpecificMethod ? " + method.equals(mostSpecificMethod));

		System.out.println("selectedMethod == mostSpecificMethod ? " + selectedMethod.equals(mostSpecificMethod));


	}
}
