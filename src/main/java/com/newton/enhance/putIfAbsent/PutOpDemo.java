package com.newton.enhance.putIfAbsent;

import java.util.HashMap;

public class PutOpDemo {

    public static void main(String[] args){
        HashMap demo1=new HashMap();
        System.out.println(demo1.put(1,"1111"));
        System.out.println(demo1.put(2,"2222"));
        //覆盖旧值
        System.out.println(demo1.put(2,"3333"));
        System.out.println(demo1);

        /*
          putIfAbsent方法主要是在向ConcurrentHashMap中添加键—值对的时候，它会先判断该键值对是否已经存在。
          如果不存在（新的entry），那么会向map中添加该键值对，并返回null。
          如果已经存在，那么不会覆盖已有的值，直接返回已经存在的值。
         */
        HashMap demo2=new HashMap();
        System.out.println(demo2.putIfAbsent(1,"t111"));
        System.out.println(demo2.putIfAbsent(2,"t2222"));
        //不能覆盖旧值
        System.out.println(demo2.putIfAbsent(2,"t3333"));
        System.out.println(demo2);



    }
}
