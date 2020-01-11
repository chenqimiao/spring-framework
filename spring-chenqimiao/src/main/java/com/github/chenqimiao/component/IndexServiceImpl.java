package com.github.chenqimiao.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/1 16:35
 * @Description:
 */
@Component("indexService")
public class IndexServiceImpl implements IndexService {


    @Autowired
    private UserService userService;


    @Autowired
	private A a;

    public IndexServiceImpl() {
        System.out.println("Construct IndexService");
    }


    public void getIndex() {
        System.out.println("get index");
    }
}
