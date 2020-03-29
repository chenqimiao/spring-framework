package com.github.chenqimiao.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/29 16:07
 * @Description:
 */
@Conditional(NoConfigurationThreeCondition.class)
@Configuration
@Import(Configuration2.class)
public class Configuration1 {

}
