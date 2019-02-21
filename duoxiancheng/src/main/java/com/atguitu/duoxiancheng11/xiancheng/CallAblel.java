package com.atguitu.duoxiancheng11.xiancheng;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//第三种实现多线程的方式：Callable
//Callable不能直接开启多线程，需要通过futureTask来开启多线程,且一个futureTask对象只能创建一个线程，
// 否则用此futureTask创建的其他线程不会执行

// FutureTask<Integer> f=new FutureTask<Integer>(c);
//new Thread(f,"A").start();
public class CallAblel implements Callable<Integer>{//Runnable{
   /* @Override
    public void run() {
        System.out.println();
    }*/

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"1111");
        return 1;
    }
}
class s{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallAblel c=new CallAblel();
        // CallAblel cc=new CallAblel();
        FutureTask<Integer> f=new FutureTask<Integer>(c);
        new Thread(f,"A").start();
        // f=new FutureTask<Integer>(c);
        new Thread(f,"B").start();

        //System.out.println( f.get()+"");.get阻塞状态，导致其他线程一直等待；while（！f.isDone()）{}轮循状态，导致轮循的线程重复访问，伤cpu
    }
}
