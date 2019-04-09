package com.wd.tech;

/**
 * FileName: Test1
 * Author: 杨明森
 * Date: 2019/4/8 11:03
 */
public class Test1 extends Test {

    public static void main(String[] args){
        new Test1().test();
    }

    public void test(){
        System.out.println(getClass().getSuperclass().getName());
    }
}
