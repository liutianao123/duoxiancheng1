package com.atguitu.duoxiancheng11.xiancheng;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class xxxx {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask <>((Callable<Integer>) () -> {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
//        作为Callable的返回值i
            return i;
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            if (i==20) {
                //利用Callable和FutureTask作为目标对象启动线程
                new Thread(futureTask,"有返回值的线程").start();
            }
        }
//        接收FutureTask的返回值
        System.out.println("子线程的返回值:" + futureTask.get());
    }
}
