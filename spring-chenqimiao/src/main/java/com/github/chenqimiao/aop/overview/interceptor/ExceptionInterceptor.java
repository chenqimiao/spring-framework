package com.github.chenqimiao.aop.overview.interceptor;

import java.lang.reflect.Method;

/**
 * @Description: 异常拦截器
 * @Author: Qimiao Chen
 * @Create: 2020-12-12 19:16
 **/
public interface ExceptionInterceptor {

	/**
	 * 异常拦截器
	 * @param proxy
	 * @param method
	 * @param args
	 * @param throwable
	 * @return
	 */
	Object intercept(Object proxy, Method method, Object[] args, Throwable throwable);

}
