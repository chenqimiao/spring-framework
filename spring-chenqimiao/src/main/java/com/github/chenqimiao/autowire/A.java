package com.github.chenqimiao.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/25 02:33
 * @Description:
 */
@Component
public class A {

	private String str;


	private B b;

	public void setB(B b) {
		this.b = b;
	}

	//可以通过@Autowired指定构造器注入，当只有单个构造方法的时候，可以省略@Autowired
	public A(B b){
		System.out.println("AAAAAAA");
		this.b = b;
	}
	public A(){

	}


	@Autowired
	private B b1;


	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}



