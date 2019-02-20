package com.atguitu.duoxiancheng11.xiancheng;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore sa=new Semaphore(3);
        for (int i = 0; i < 21; i++) {
            Random r=new Random();
            new Thread(()->{
                try {
                    sa.acquire();//acqiore占用 抢占
                    System.out.println(Thread.currentThread().getName()+"线程开启");
                    try {
                        int l=r.nextInt(30);
                       TimeUnit.SECONDS.sleep(l);
                        System.out.println(Thread.currentThread().getName()+"出去"+l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               finally {
                    sa.release();//release释放
                }

            },i+"   A").start();
        }
    }
}
