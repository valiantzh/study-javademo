package com.study.basis.concurrency.chapter8;

import java.util.concurrent.*;

/**
 * 线程间交换数据
 * 应用场景:遗传算法,校对工作
 * @author valiantzh
 * @version 1.0
 */
public class ExchangerTest {
    public static final Exchanger<String> exgr = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String A = "银行流水A";//A员工录入银行流水数据
                try {
                    exgr.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String B = "银行流水B";//B员工录入银行流水数据
                try {
                    //String A = exgr.exchange("B");
                    String A = exgr.exchange("B", 10, TimeUnit.SECONDS);

                    System.out.println(" A和B数据是否一致:"+B.equals(A)+",A录入的是:"+A+",B录入的是:"+B);
                } catch (InterruptedException | TimeoutException e) {
                    e.printStackTrace();
                }

            }
        });

        threadPool.shutdown();
    }
}
