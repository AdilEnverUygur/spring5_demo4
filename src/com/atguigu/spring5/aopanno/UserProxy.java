package com.atguigu.spring5.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//增强的类
@Component
@Aspect     //生成代理对象
public class UserProxy {

    //相同切入点抽取
    @Pointcut(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void pointDemo(){

    }

    //前置通知
    //@Before注解表示作为前置通知
    @Before(value = "pointDemo()")
    public void before(){
        System.out.println("before.....");
    }

    @After(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void after(){
        System.out.println("After.....");
    }

    //后置通知(返回通知)
    @AfterReturning(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void afterReturning(){
        System.out.println("AfterReturning.....");
    }

    //异常通知
    @AfterThrowing(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void afterThrowing(){
        System.out.println("AfterThrowing.....");
    }

    //环绕通知
    @Around(value = "execution(* com.atguigu.spring5.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕之前.....");
        //被增强的方法
        proceedingJoinPoint.proceed();

        System.out.println("环绕之后.....");
    }
}
