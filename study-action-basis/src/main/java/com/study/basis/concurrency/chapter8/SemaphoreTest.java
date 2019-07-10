package com.study.basis.concurrency.chapter8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量
 * 可以做流量控制
 * @author valiantzh
 * @version 1.0
 */
public class SemaphoreTest {
    public static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s = new Semaphore(10);//N=10,允许N个并发执行

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println(" save data");
                        s.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }

        threadPool.shutdown();
        System.out.println(" thread pool shutdown");
    }
}
