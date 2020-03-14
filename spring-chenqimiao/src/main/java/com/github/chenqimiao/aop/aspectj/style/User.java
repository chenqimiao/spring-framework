package com.github.chenqimiao.aop.aspectj.style;

import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/14 15:01
 * @Description:
 */
public class User {

	public void advisedMethod(){
		System.out.println("AdvisedMethod join point");
		//throw new RuntimeException();
	}
}
