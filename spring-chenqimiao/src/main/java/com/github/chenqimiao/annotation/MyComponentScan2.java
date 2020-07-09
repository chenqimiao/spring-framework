package com.github.chenqimiao.annotation;

import org.springframework.core.annotation.AliasFor;

/**
 * @Author: Qimiao Chen
 * @Date: 2020/7/9 8:32 下午
 */
@MyComponentScan1
public @interface MyComponentScan2 {


	/**
	 * 与元注解 @MyComponentScan1 同名属性，隐形属性覆盖
	 *
	 * @return
	 */
	String[] scanBasePackages() default {};


	@AliasFor("scanBasePackages")
	String[] packages() default {}; // packages 覆盖了 scanBasePackages 覆盖了元注解 scanBasePackages 显性属性覆盖
}
