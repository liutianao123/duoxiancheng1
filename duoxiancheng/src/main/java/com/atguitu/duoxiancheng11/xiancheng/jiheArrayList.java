package com.atguitu.duoxiancheng11.xiancheng;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class jiheArrayList {
    public static void main(String[] args) {
        //List l= new ArrayList();//报错ConcurrentModificationException的原因：同时多个线程抢一个资源，导致资源损坏
        //ArrayList是线程不安全的，当写比读快时，就会出现null值

        //List l2=new Vector();//多线程高并发项目不许用vactor，对所有操作都加上synchronized严重影响了效率，可能出现宕机

        // List l3=Collections.synchronizedList(new ArrayList<>());
        // synchronizedlist在写操作上效率超过copyonwritearraylist，读写操作比较平均；

        List l4=new  CopyOnWriteArrayList();
        //copyonwritearraylist在读操作上和ArrayList差不多，但是在写操作上会出现不断复制，特别占用性能(实现了写时复制，读写分离)，
        // 多线程高并发情况下，读多写少，所有选用copyonwritearraylist

        //List l1=Arrays.asList("1","2");
        List l1=Arrays.asList("1","2");
        //l.forEach(System.out::println);
        for (int i = 1; i <=50 ; i++) {
            new Thread(()->{
                l4.add(UUID.randomUUID().toString().substring(0,4));
               // l1.add("1");//UnsupportedOperationException出现原因：asList创建了一个自己内部的ArrayList对象，
                // 这个对象虽然和ArrayList都继承了AbstractList类，但是这个类并没有重写add和remove方法，所有报错
                System.out.println(l4);
            },String.valueOf(i)).start();
        }
        System.out.println(l4);//L为空的原因：先运行完main再运行的其他线程

    }
}
