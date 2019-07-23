package com.study.basis.concurrency.chapter4;

import com.study.basis.utils.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断
 * @author valiantzh
 * @version 1.0
 */
public class ThreadInterruptTest {

    public static void main(String[] args) {
        //sleepThread 不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
        //
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        //休眠5秒,使线程充分运行
        SleepUtils.second(5);

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread interrupted is "+ sleepThread.isInterrupted());
        System.out.println("BusyThread insterrupted is "+busyThread.isInterrupted());

    }
    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            SleepUtils.second(10);//抛出InterruptedException的线程,中断标志位被清除
        }
    }
    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true){

            }
        }
    }
}
