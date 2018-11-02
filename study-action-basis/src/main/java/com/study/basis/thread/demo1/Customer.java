package com.study.basis.thread.demo1;


//消费者
public class Customer {
  //注入一个工厂实例
    private Factory factory;

    public Customer(Factory factory){
        this.factory = factory;
    }
    public void custome(int val){
        new Thread(){
            @Override
            public void run() {
                factory.custome(val);
            }
        }.start();
    }
}
