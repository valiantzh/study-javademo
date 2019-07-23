package com.study.basis.concurrency.chapter3;

/**
 * 双重检查锁定
 * @author valiantzh
 * @version 1.0
 */
public class DoubleCheckedLocking {
    private static DoubleCheckedLocking instance;

    public static DoubleCheckedLocking getInstance(){
        if(instance == null){                             //第一次检查
            synchronized (DoubleCheckedLocking.class){    //加锁
                if(instance == null){                     //第二次检查
                    instance = new DoubleCheckedLocking();//问题根源

                    //创建对象可以分解为3行伪代码
                    //memory =  allocate(); //1:分配对象的内存空间
                    //cotrInstance(memory); //2:初始化对象
                    //instance = memory;    //3:设置instance指向刚分配的内存地址
                    //2,3之间,可能会被重排序,其他线程可能使用未经过初始化的对象
                }
            }
        }
        return instance;
    }
}
