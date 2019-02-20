package com.atguitu.duoxiancheng11.xiancheng;
//synchronized实现同步锁的基础：Java中的任何对象都可以作为锁；
// 普通同步方法，锁的是当前对象；
// 静态同步方法，锁的是class类；
// synchronized代码块，锁的是静态代码块的内容；
class ziyuan{
    public static synchronized void z1(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"  z1");
    }
    public  synchronized void z2(){
        System.out.println(Thread.currentThread().getName()+"  z2");
    }
}
public class suo {
    //1、两个都是普通同步方法的情况下，
    // 答：下方代码先执行a，原因：a线程下方的线程休眠
    //2、z1暂停3秒，两个都是同步方法的情况下
    // 答：下方代码先执行a，原因：同步方法锁定了当前对象
    //3、两个线程一个同步方法一个不是同步方法的情况下（在调的用z1方法中加休眠），
    // 答：先执行b，原因：a线程加锁并不影响没有同步的方法
    //4、两个线程分布访问两个资源的同步方法的情况下（在调的用z1方法中加休眠），
    // 答：先执行b，原因：a，b两线程分别访问两个资源，互相之间不受影响
    //5、静态同步方法的情况下（在调的用z1方法中加休眠），
    // 答：先执行a,原因：静态方法修饰的是全局的，加锁代表了对整个类加锁
    //6、静态同步方法，两部手机（在调的用z1方法中加休眠）？
    // 答：先执行a，原因：静态方法修饰的是全局的，加锁代表了对整个类加锁，与对象无关；
    //7、一个普通同步，一个静态同步，一部手机（在调的用z1方法中加休眠）？
    // 答：先执行b，原因普通同步方法锁定整个对象，而静态方法的锁定是全局锁，两者没有任何关系（例子：小米手机的加锁（同步锁）和小米工厂门锁了无关（全局锁））
    //8、一个普通同步，一个静态同步，两部手机（在调的用z1方法中加休眠）？
    //答：先执行b，原因：7
    public static void main(String[] args) throws InterruptedException {
        ziyuan z=new ziyuan();
        ziyuan z2=new ziyuan();
        new Thread(()->{
            z.z1();
        },"a").start();
        Thread.sleep(1000);
        new Thread(()->{
            z2.z2();
        },"b").start();
    }
}
