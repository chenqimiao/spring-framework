package com.github.chenqimiao.component;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: chenqimiao
 * @Date: 2020/1/12 13:15
 * @Description:
 */
public class IndexService {

	private AbstractUser obj;

	public void printUserName(){
		if(obj != null){

			System.out.println(obj.getName());

		}else {
			//before this change ,program will go here
			System.out.println("obj is null");
		}
	}

	public void setObj(AbstractUser obj) {
		this.obj = obj;
	}
}
