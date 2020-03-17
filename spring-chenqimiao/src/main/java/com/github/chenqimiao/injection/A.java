package com.github.chenqimiao.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2020/2/29 22:13
 * @Description:
 */
@Component
public class A {


	public A(){

	}

	@Autowired(required = false)
	public A(B b){
		System.out.println("B");
	}


	@Autowired(required = false)
	public A(SuperB b){
		System.out.println("superB");
	}

//	@Autowired(required = false)
//	public A(B b, C c, D d){
//		System.out.println("BCD");
//	}
//
//	public A(B b, C c, D d, E e){
//		System.out.println("BCDE");
//	}

}
