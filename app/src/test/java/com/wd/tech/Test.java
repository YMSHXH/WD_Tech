package com.wd.tech;

import java.util.Date;
/**
 * FileName: Test
 * Author: 杨明森
 * Date: 2019/4/8 10:57
 */
public class Test extends Date {

    public static void main(String[] args){
        new Test().test();


    }

    public void test(){
        System.out.println(super.getClass().getName());
    }
}