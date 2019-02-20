package com.atguitu.duoxiancheng11.xiancheng;
//lambada表达式的前提：必须是函数式接口（即接口只有一个方法）
@FunctionalInterface//声明函数式接口
interface  lambadalx{
    public boolean m(int i,int k);
    //public void d();
    public default void m1(){
//java8以后接口中static,default可以有多个，且可以在函数式接口中
    }
}
//拷贝小括号，写死右箭头，落地大括号。
public class lianxi2 {
    public static void main(String[] args) {
       /* lambadalx l=new lambadalx() {
            @Override
            public boolean m() {
                System.out.println("11");
                return true;
            }
        };*/
        lambadalx l1=(i,k)-> {
            System.out.println(i*k);
            return false;
        };
        System.out.println(l1.m(6,5));
    }
}
