package com.github.chenqimiao.autowiretest;

import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/25 02:33
 * @Description:
 */
@Component
public class A {

	private B b;

	//可以通过@Autowired指定构造器注入，当只有单个构造方法的时候，可以省略@Autowired
	public A(B b){
		System.out.println("AAAAAAA");
		this.b = b;
	}

}
