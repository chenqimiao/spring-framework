package com.github.chenqimiao.component;

import org.springframework.beans.factory.Aware;

/**
 * @Auther: chenqimiao
 * @Date: 2020/1/5 22:29
 * @Description:
 */
public interface BAware extends Aware {


	void setB(B b);
}
