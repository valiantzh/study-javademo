package com.study.basis.designpattern.singleton;

/*
懒汉式(双重检查加锁版本)
 */
public class SingletonDemo1 {
    private volatile static SingletonDemo1 instance;
    private SingletonDemo1(){

    }
    public static SingletonDemo1 getInstance(){
        //检查实例如果不存在，进入同步代码块
        if(instance == null){
            //
            synchronized (SingletonDemo1.class) {
                //进入同步块，再次检查实例是否为null
                if(instance == null){
                    instance = new SingletonDemo1();
                }
            }
        }
        return instance;
    }
}
