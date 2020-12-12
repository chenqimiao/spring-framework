package com.github.chenqimiao.aop.overview.interceptor;

import java.lang.reflect.Method;

/**
 * @Description: 前置拦截器
 * @Author: Qimiao Chen
 * @Create: 2020-12-12 19:15
 **/
public interface BeforeInterceptor {

	/**
	 * 前置执行方法
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 */
	Object before(Object proxy, Method method, Object[] args);

}
