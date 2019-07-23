package com.study.basis.concurrency.chapter4;

import com.study.basis.utils.DateUtils;
import com.study.basis.utils.SleepUtils;


/**
 * 等待/通知机制
 * @author valiantzh
 * @version 1.0
 */
public class ThreadWaitNotify {
    static boolean flag =  true;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        SleepUtils.second(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }
    static class Wait implements Runnable {

        @Override
        public void run() {
            //加锁,拥有lock对象的monitor
            synchronized(lock){
                //当条件不满足时,继续wait,同时释放lock的锁
                while(flag){

                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait @ " + DateUtils.nowTime2String());
                        lock.wait();
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                }

                //满足条件时,完成工作
                System.out.println(Thread.currentThread() + " flag is false. running @ "+ DateUtils.nowTime2String());
            }
        }
    }
    static class Notify implements Runnable{

        @Override
        public void run() {
            //加锁,拥有lock对象的monitor
            synchronized (lock){
                //
                System.out.println(Thread.currentThread() +" hold lock. notify @ "+DateUtils.nowTime2String());

                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }
            //SleepUtils.second(1);

            //再次加锁
            synchronized(lock){
                System.out.println(Thread.currentThread() +" hold lock again. notify @ "+DateUtils.nowTime2String());
                SleepUtils.second(5);
            }
        }
    }
}
