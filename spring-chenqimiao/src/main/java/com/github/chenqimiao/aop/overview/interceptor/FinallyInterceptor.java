package com.github.chenqimiao.aop.overview.interceptor;

import java.lang.reflect.Method;

/**
 * @Description: Finally 拦截器
 * @Author: Qimiao Chen
 * @Create: 2020-12-12 19:16
 **/
public interface FinallyInterceptor {
	/**
	 * 最终执行
	 * @param proxy
	 * @param method
	 * @param args
	 * @param returnVal
	 * @return
	 */
	Object finalize(Object proxy, Method method, Object[] args, Object returnVal);

}
