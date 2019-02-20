package com.atguitu.duoxiancheng11.xiancheng;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ziyuan1{
    private Lock l=new ReentrantLock();
    private int number=30;
    public void shixian(){
       /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        l.lock();
        try{
            if(number>0){
                number--;
                System.out.println((number+1)+"  "+Thread.currentThread().getName());
            }
        }finally {
            l.unlock();
        }

    }
}
public class dxc {
    //企业级多线程编程
    //资源  线程  实现
    //高内聚  低耦合
    public static void main(String[] args) {
        ziyuan1 z=new ziyuan1();
        /*new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i=1;i<=40;i++) {
                    z.shixian();
                }
            }
        },"A").start();*/
        new Thread(()->{for (int i=1;i<=40;i++) z.shixian();},"S").start();
        new Thread(()->{
            for (int i = 1; i <=40; i++)
                z.shixian();
        },"d").start();
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=40;i++) {
                    z.shixian();
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=40;i++) {
                    z.shixian();
                }
            }
        },"C").start();*/
    }

}
