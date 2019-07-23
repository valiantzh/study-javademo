package com.study.basis.concurrency.chapter3;

/**
 * @author valiantzh
 * @version 1.0
 */
public class SafeDoubleCheckedLocking {
    private volatile static SafeDoubleCheckedLocking instance;

    public static SafeDoubleCheckedLocking getInstance(){
        if(instance == null){                             //第一次检查
            synchronized (SafeDoubleCheckedLocking.class){    //加锁
                if(instance == null){                     //第二次检查
                    instance = new SafeDoubleCheckedLocking();//instance为volatile ,没有可见性问题
                }
            }
        }
        return instance;
    }
}
