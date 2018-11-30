package com.study.basis.designpattern.singleton;

/*
 *静态内部类方式
 */
public class SingletonDemo2 {
    private static class SingletonHolder{
        private static final SingletonDemo2 INSTANCE = new SingletonDemo2();
    }
    private SingletonDemo2() {

    }
    public static final  SingletonDemo2 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
