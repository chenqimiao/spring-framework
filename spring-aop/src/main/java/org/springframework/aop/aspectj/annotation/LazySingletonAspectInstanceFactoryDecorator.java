/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.aop.aspectj.annotation;

import java.io.Serializable;

import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

/**
 * Decorator to cause a {@link MetadataAwareAspectInstanceFactory} to instantiate only once.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @since 2.0
 *
 * 装饰器模式
 *
 * 装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。
 */
@SuppressWarnings("serial")
public class LazySingletonAspectInstanceFactoryDecorator implements MetadataAwareAspectInstanceFactory, Serializable {

	private final MetadataAwareAspectInstanceFactory maaif;

	@Nullable
	private volatile Object materialized;


	/**
	 * Create a new lazily initializing decorator for the given AspectInstanceFactory.
	 * @param maaif the MetadataAwareAspectInstanceFactory to decorate
	 */
	public LazySingletonAspectInstanceFactoryDecorator(MetadataAwareAspectInstanceFactory maaif) {
		Assert.notNull(maaif, "AspectInstanceFactory must not be null");
		this.maaif = maaif;
	}


	@Override
	//当Advised方法被调用的时候，才会调用此方法获取相关的Aspect Bean,进行Advice方法的执行
	public Object getAspectInstance() {
		Object aspectInstance = this.materialized;
		if (aspectInstance == null) {
			Object mutex = this.maaif.getAspectCreationMutex();
			if (mutex == null) {
				//这里会实例化或者获取Bean
				aspectInstance = this.maaif.getAspectInstance();
				this.materialized = aspectInstance;
			}
			else {
				synchronized (mutex) {
					aspectInstance = this.materialized;
					if (aspectInstance == null) {
						aspectInstance = this.maaif.getAspectInstance();
						this.materialized = aspectInstance;
					}
				}
			}
		}
		return aspectInstance;
	}

	public boolean isMaterialized() {
		return (this.materialized != null);
	}

	@Override
	@Nullable
	public ClassLoader getAspectClassLoader() {
		return this.maaif.getAspectClassLoader();
	}

	@Override
	public AspectMetadata getAspectMetadata() {
		return this.maaif.getAspectMetadata();
	}

	@Override
	@Nullable
	public Object getAspectCreationMutex() {
		return this.maaif.getAspectCreationMutex();
	}

	@Override
	public int getOrder() {
		return this.maaif.getOrder();
	}


	@Override
	public String toString() {
		return "LazySingletonAspectInstanceFactoryDecorator: decorating " + this.maaif;
	}

}
