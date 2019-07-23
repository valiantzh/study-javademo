package com.study.basis.concurrency.chapter3;

/**
 * 延迟初始化--线程安全
 * 同步处理实现线程安全
 * @author valiantzh
 * @version 1.0
 */
public class SafeLazyInitialization {
    private static SafeLazyInitialization instance;

    //synchronized同步处理,到时导致性能开销
    public static synchronized SafeLazyInitialization getInstance() {
        if(instance == null){
            instance = new SafeLazyInitialization();
        }
        return instance;
    }
}
