package com.atguitu.duoxiancheng11.xiancheng;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//在消费者和生产者模式下，多线程的判断必须使用while禁止使用if
class lianxi{
    private int i=0;
    private Lock lock=new ReentrantLock();
    private Condition c=lock.newCondition();
    /*public synchronized void xiao(){
        while(i==0){//if在线程多时可能控制不住当两个生产线程都在wait等待时，调用另外的一个消费线程，
            // 消费线程启用其他线程，两个生产线程启动，一个先抢到资源，执行完毕，当另一个生产线程在这个线程后获取资源时，会导致生产过多，
            // 原因：if并不会再次判断，所以使用while(线程判断用while（生产者消费者模式下）)
            //wait和notifyAll时object类中的方法
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        i--;
        System.out.println(Thread.currentThread().getName()+" "+i);
        this.notifyAll();
    }
    public synchronized void sheng(){

        while(i!=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        i++;
        System.out.println(Thread.currentThread().getName()+" "+i);
        this.notifyAll();
    }*/
    public void sheng(){
        lock.lock();//lock不在使用wait和notifyall
        try{
            while(i!=0){//不要用if，要有while*****************
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
            System.out.println(Thread.currentThread().getName()+"  "+i);
           c.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void xiao(){
        lock.lock();
        try{
            while(i==0){
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i--;
            System.out.println(Thread.currentThread().getName()+"  "+i);
           c.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
public class xianshengxiao {
    public static void main(String[] args) {
        lianxi l=new lianxi();
        new Thread(()->{
            for (int i = 0; i <20; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                l.sheng();
            }

        },"A").start();
        new Thread(()->{
            for (int i = 0; i <20 ; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                l.xiao();
            }

        },"B").start();
        new Thread(()->{
            for (int i = 0; i <20; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                l.sheng();
            }

        },"D").start();
        new Thread(()->{
            for (int i = 0; i <20 ; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                l.xiao();
            }

        },"C").start();

    }
}
