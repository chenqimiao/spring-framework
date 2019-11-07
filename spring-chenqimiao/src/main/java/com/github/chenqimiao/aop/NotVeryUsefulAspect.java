package com.github.chenqimiao.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.stereotype.Component;

/**
 * @Auther: chenqimiao
 * @Date: 2019/11/3 18:15
 * @Description:
 */
//@Component
//@Aspect
public class NotVeryUsefulAspect {


    @Pointcut(value = "execution(* com.github.chenqimiao.component..*(..))")
    public void notVeryUsefulPointcut() {

    }

    @After("notVeryUsefulPointcut()")
    public void notVeryUsefulAdvice() {
        System.out.println("---------------after aop---------------");
    }

    @Before("notVeryUsefulPointcut()")
    public void littleUsefulAdvice(JoinPoint jp) {
        System.out.println("---------------before aop---------------");
    }
}
