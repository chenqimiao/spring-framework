package com.github.chenqimiao.circular.reference.resolvable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2020/4/15 11:24
 * @Description:
 */
@Component
public class B {

	@Autowired
	private A a;
}
