package com.study.basis.concurrency.chapter8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author valiantzh
 * @version 1.0
 */
public class CyclicBarrierTest3 {
    static CyclicBarrier c = new CyclicBarrier(2);//N=2,表示屏障挡截的线程数

    public static void main(String[] args) {
        Thread td = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                //System.out.println(1+","+c.getNumberWaiting());
            }
        });

        td.start();
        //System.out.println(2+","+c.getNumberWaiting());
        td.interrupt();

        try {
            c.await();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(c.isBroken());
        }
    }
}
