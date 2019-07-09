package com.study.basis.concurrency.chapter8;

/**
 * 等待多线程完成--join()实现
 * @author valiantzh
 * @version 1.0
 */
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        Thread  td1 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("thread1 finish");
            }
        });

        Thread td2 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("thread2 finish");
            }
        });

        td1.start();
        td2.start();
        //线程join方法实现等待线程完成
        td1.join();
        //System.out.println("td1 finish");
        td2.join();
        //System.out.println("td2 finish");
        System.out.println("all thread finish");
    }
}
