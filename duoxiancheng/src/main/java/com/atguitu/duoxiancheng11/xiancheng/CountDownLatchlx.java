package com.atguitu.duoxiancheng11.xiancheng;


import lombok.Getter;

import java.util.concurrent.CountDownLatch;

class lx{
    public void k(){
        System.out.println(Thread.currentThread().getName()+"被消灭了");
    }
}
public class CountDownLatchlx {
    public static void main(String[] args) throws InterruptedException {
        lx l=new lx();
        CountDownLatch cdl=new CountDownLatch(6);
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                l.k();
                cdl.countDown();//减少数字
            },guo.lx(i)).start();
        }
        cdl.await();
        System.out.println(Thread.currentThread().getName()+"**********一统华夏");
    }
}
enum guo{
    ONE(1,"齐国"),TWO(2,"楚国"),THERE(3,"燕国"),FOURE(4,"韩国"),FIVE(5,"赵国"),SIX(6,"魏国");
    @Getter
    private int id;
    @Getter
    private String name;

    guo(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public static String lx(int i){
        guo[] values = guo.values();
        for (guo guo:values){
            if(guo.getId()==i){
                return guo.getName();
            }
        }
        return "";
    }

}
