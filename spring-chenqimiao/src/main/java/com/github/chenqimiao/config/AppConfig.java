package com.github.chenqimiao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.github.chenqimiao.component.UserService;
import com.github.chenqimiao.component.UserServiceImpl;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/1 16:34
 * @Description:
 */
@Configuration
@ComponentScan("com.github.chenqimiao")
@EnableAspectJAutoProxy
public class AppConfig {
    //@Bean(initMethod = "initMethod")
    public UserService userService() {
        return new UserServiceImpl();
    }
}
