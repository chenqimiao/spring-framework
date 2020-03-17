package com.github.chenqimiao.component;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/3 18:29
 * @Description:
 */
//@Component
public class UserServiceImpl implements InitializingBean, UserService {

   // @Autowired
    private IndexService indexService;


    public UserServiceImpl() {
        System.out.println("Construct UserServiceImpl");

    }

    @PostConstruct
    public void postConstruct() {
        // System.out.println("userService postConstruct");
    }

    public void getUserById(Integer id) {
        indexService.getIndex();
        System.out.println("get user with user id " + id);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // System.out.println("userService InitializingBean#afterPropertiesSet");

    }

    public void initMethod() {
        // System.out.println("userService initMethod");

    }
}
