package com.github.chenqimiao.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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
		//this.b = b;
	}

	//可以通过@Autowired指定构造器注入，当只有单个构造方法的时候，可以省略@Autowired.
	//@Autowired无论在字段方法构造器上注解，都有这样一个特性，当类型匹配到多个candidate的时候，
	//在没有使用@Qulifier、@Primary注解的情况下，会将对象名作为最终的fallback限定匹配，
	//@Resource注解则刚好相反，先通过名称匹配，如果没找到，则通过类型匹配.
	@Autowired
	public A(@Qualifier(value = "b") B subB, @Value("xxx") String c){
		System.out.println("AAAAAAA");
		this.b = b;
	}
	public A(){

	}


	@Autowired
	private B subB;


	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}



