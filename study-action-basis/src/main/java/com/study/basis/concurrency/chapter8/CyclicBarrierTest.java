package com.study.basis.concurrency.chapter8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 同步屏障 CyclicBarrier
 *
 * CyclicBarrier的计数器可以使用reset()方法重置
 * @author valiantzh
 * @version 1.0
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2);//N=2,表示屏障挡截的线程数
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(1);

            }
        }).start();

        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(2);

    }
}
