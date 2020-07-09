package com.github.chenqimiao.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @Author: Qimiao Chen
 * @Date: 2020/7/9 8:30 下午
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@MyComponentScan
public @interface MyComponentScan1 {


	@AliasFor(annotation = ComponentScan.class, attribute = "value") // 隐性别名
			// "多态"，子注解提供新的属性方法引用"父"（元）注解中的属性方法
	String[] scanBasePackages() default {"#"};
}
