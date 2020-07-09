package com.github.chenqimiao.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * @Description: 自定义Component
 * @Author: Qimiao Chen
 * @Create: 2020-07-07 20:43
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
@Component // Component 派生性
public @interface MyComponent {
}
