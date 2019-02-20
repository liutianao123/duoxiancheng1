package com.atguitu.duoxiancheng11.xiancheng;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class jiheHashSetandHashMap {
    public static void main(String[] args) {
        //Map m=new HashMap(); //ConcurrentModificationException报错
       /* Map m1=new ConcurrentHashMap();
        for (int i = 0; i <30 ; i++) {
            int finalI = i;
            new Thread(()->{
               m1.put(finalI +"",UUID.randomUUID().toString().substring(1,5));
                System.out.println(m1);
            }).start();
        }*/
        //Set s=new HashSet();//ConcurrentModificationException报错
        Set s1=new CopyOnWriteArraySet();
        for (int i = 0; i <30 ; i++) {
            new Thread(()->{
                s1.add(UUID.randomUUID().toString().substring(1,4));
                System.out.println(s1);
            },String.valueOf(i)).start();
        }
    }
}
