package com.study.basis.concurrency.chapter8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 等待多线程完成的CountDownLatch
 * @author valiantzh
 * @version 1.0
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);//N=2,N作为计数器,需要等待N个点完成

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1+","+c.getCount());
                c.countDown();//每次调countDown()方法,N减1,await方法会阻塞当前线程,直到N变成零
                System.out.println(2+","+c.getCount());
                c.countDown();
            }
        }).start();
        //c.await();
        c.await(10, TimeUnit.SECONDS);
        System.out.println(3);
    }
}
