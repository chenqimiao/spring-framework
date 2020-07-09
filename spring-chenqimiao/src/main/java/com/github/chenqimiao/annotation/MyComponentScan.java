package com.github.chenqimiao.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @Description: 自定义ComponentScan
 * @Author: Qimiao Chen
 * @Create: 2020-07-09 20:09
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@ComponentScan
public @interface MyComponentScan {

	// implicit alias for 隐性别名
	@AliasFor(annotation = ComponentScan.class, value = "basePackages")
	String[] value() default {};

	// Explicit alias for 显性别名
	@AliasFor("value")
	String[] myBasePackages() default {};



}
