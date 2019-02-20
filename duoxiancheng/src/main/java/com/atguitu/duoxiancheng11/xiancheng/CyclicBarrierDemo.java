package com.atguitu.duoxiancheng11.xiancheng;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;

class lx1 implements Callable<Integer>{
    //private Lock l=new ReentrantLock();
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"进来了");
        return 1;
    }
    /*public void xx(){
        l.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"111111111111");
        }finally {
            l.unlock();
        }
    }*/
}
public class CyclicBarrierDemo {
    public static void main(String[] args)  {
        CyclicBarrier c = new CyclicBarrier(6,()->{
            System.out.println("aaaaaaaaaaa");
        });
        lx1 lx = new lx1();
        for (int i = 0; i <5 ; i++) {
            FutureTask<Integer> f = new FutureTask<Integer>(lx);//只会执行一次，然后就会终止
            new Thread(f,"CCCCCCCCCCC  "+i).start();
        }


        /*for (int i = 6; i >= 1; i--) {

            new Thread(()->{
                try {
                    lx.xx();
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, i + "  B").start();

        }*/
    }
}

