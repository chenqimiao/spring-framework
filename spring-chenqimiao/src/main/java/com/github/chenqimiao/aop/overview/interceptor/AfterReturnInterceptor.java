package com.github.chenqimiao.aop.overview.interceptor;

import java.lang.reflect.Method;

/**
 * @Description: 后置返回拦截器
 * @Author: Qimiao Chen
 * @Create: 2020-12-12 19:15
 **/
public interface AfterReturnInterceptor {

	/**
	 * 后置执行方法
	 * @param proxy
	 * @param method
	 * @param args
	 * @param returnVal
	 * @return
	 */
	Object after(Object proxy, Method method, Object[] args, Object returnVal);

}
