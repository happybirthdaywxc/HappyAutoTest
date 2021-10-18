package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {
    //如果被依赖的方法执行失败，当前执行方法会被忽略
    @Test
    public void test1(){
        System.out.println("test1 run");
        throw new RuntimeException();
    }
    @Test(dependsOnMethods = "test1")
    public void test2(){
        System.out.println("test2 run");
    }
}
