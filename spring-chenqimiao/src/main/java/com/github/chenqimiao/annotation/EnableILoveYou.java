package com.github.chenqimiao.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 激活 "I love you" 模块注解
 * @Author: Qimiao Chen
 * @Create: 2020-07-09 20:37
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//@Import(ILoveYouConfiguration.class)// 1.直接Import Configuration class
@Import(ILoveYouImportBeanDefinitionRegistrar.class) //2. Import ImportBeanDefinitionRegistrar 控制力度更细一些，可以把控BeanDefinition的生命周期
//@Import(ILoveYouImportSelector.class) //3. Import ImportSelector 可以通过条件选择注入的Configuration

// Enable模块驱动 是 Spring boot 自动装配出现之前比较流行的一种装配方式.
public @interface EnableILoveYou {
}
