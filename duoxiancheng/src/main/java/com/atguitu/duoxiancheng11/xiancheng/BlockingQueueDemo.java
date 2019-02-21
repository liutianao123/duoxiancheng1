package com.atguitu.duoxiancheng11.xiancheng;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue bq=new ArrayBlockingQueue(3);
        //异常状态下的add，remove，element
      /* bq.add("A");
        bq.add("B");
       bq.add("C");*/
        //System.out.println(bq.add("A"));
       /* bq.remove();
        bq.remove();
        bq.remove();*/
      //  System.out.println( bq.remove());

       // System.out.println(bq.element());先到先得，先入先出
        //特殊值offer(boolean返回值)，poll(如果删除数量超过队列中的内容后，返回null)，peek(返回和element相同，如果队列中没有数据返回null)
      /*  bq.offer("a");
        bq.offer("a");
        bq.offer("a");
        System.out.println(bq.offer("a"));*/
        /*bq.poll();
        bq.poll();bq.poll();bq.poll();

        System.out.println(bq.poll());*/
       // System.out.println(bq.peek());
        //延时offer(对象，时间，单位)，poll（时间，单位）
        //bq.offer("A",2l, TimeUnit.SECONDS);
        //bq.poll(2l, TimeUnit.SECONDS);
        //阻塞状态put，take  *****用阻塞时，要注意，严谨再严谨，不然会导致整个项目崩溃
       /* bq.put("a");
        bq.put("a");
        bq.put("a");
        bq.put("b");*/

    }
}
