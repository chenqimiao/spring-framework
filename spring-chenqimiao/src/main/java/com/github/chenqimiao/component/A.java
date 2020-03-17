package com.github.chenqimiao.component;

import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/7 15:23
 * @Description:
 */
@Component
//@Scope("singleton")
public class A implements BAware{

	//@Autowired
	private B b;


	public void setB(B b) {
		this.b = b;
	}

	public B getB() {
		return b;
	}


	public A (){
		System.out.println("Call A Constructor ");
	}

}
