package com.github.chenqimiao.scope;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/6 09:48
 * @Description:
 */
public class ThreadLocalScope implements Scope {

	public static final String SCOPE_NAME = "thread-local";

	private static final NamedThreadLocal<Map<String,Object>> threadScope = new NamedThreadLocal<Map<String,Object>>(SCOPE_NAME){
		@Override
		protected Map<String,Object> initialValue() {
			return new HashMap<>();
		}
	};

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		Map<String,Object> scopedMap = threadScope.get();
		Object obj = scopedMap.get(name);
		if(obj == null){
			obj = objectFactory.getObject();
			scopedMap.put(name, obj);
		}
		return obj;
	}

	@Override
	public Object remove(String name) {
		Map<String,Object> scopedMap = threadScope.get();
		return scopedMap.remove(name);
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
		System.out.println("Bean [" + name + "] 被销毁啦..");
	}

	@Override
	public Object resolveContextualObject(String key) {
		return threadScope.get().get(key);
	}

	@Override
	public String getConversationId() {
		//返回线程id
		return String.valueOf(Thread.currentThread().getId());
	}
}
