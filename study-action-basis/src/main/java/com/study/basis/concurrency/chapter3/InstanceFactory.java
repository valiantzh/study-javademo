package com.study.basis.concurrency.chapter3;

import sun.security.jca.GetInstance;

/**
 * @author valiantzh
 * @version 1.0
 */
public class InstanceFactory {

    private static class InstanceHolder{
        public static InstanceFactory instance = new InstanceFactory();
    }

    public static InstanceFactory getInstance(){
        return InstanceHolder.instance;  //InstanceHolder类被初始化.
        // JVM在执行初始化期间,会去获得一个锁,这个锁可以同步多线程对同一个类的初始化
    }
}
