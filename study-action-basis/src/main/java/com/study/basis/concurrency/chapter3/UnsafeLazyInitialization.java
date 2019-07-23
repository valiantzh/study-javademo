package com.study.basis.concurrency.chapter3;

/**
 * 延迟初始化--非线程安全
 * @author valiantzh
 * @version 1.0
 */
public class UnsafeLazyInitialization {
    private static UnsafeLazyInitialization instance;

    public static UnsafeLazyInitialization getInstance() {
        if(instance ==null){
            instance = new UnsafeLazyInitialization();
        }
        return instance;
    }
}
