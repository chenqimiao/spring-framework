package com.github.chenqimiao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.chenqimiao.component.IndexService;
import com.github.chenqimiao.config.AppConfig;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/1 16:35
 * @Description:
 */
public class TestApplication {

    public static void main(String args[]) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        ac.getBean(IndexService.class);
    }
}
