package com.study.basis.thread.demo1;

//生产者
public class Producer {
  //注入一个工厂实例
    private Factory factory;

    public Producer(Factory factory){
        this.factory = factory;
    }
    //开启一个新的线程，传入待生产的数量，调用工厂的生产方法
    public void produce(int val){
        new Thread(){
            @Override
            public void run() {
                factory.produce(val);
            }
        }.start();
    }
}
