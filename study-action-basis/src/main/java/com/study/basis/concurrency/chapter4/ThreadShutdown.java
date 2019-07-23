package com.study.basis.concurrency.chapter4;

import com.study.basis.utils.SleepUtils;

/**
 * 安全的终止线程
 * @author valiantzh
 * @version 1.0
 */
public class ThreadShutdown {

    public static void main(String[] args) {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();

        SleepUtils.second(1);
        countThread.interrupt();

        Runner two = new Runner();
        countThread =  new Thread(two, "CountThread");
        countThread.start();
        //
        SleepUtils.second(2);
        two.cancel();
    }

    //静态内部类
    private static class Runner implements Runnable{
        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while(on && !Thread.currentThread().isInterrupted()){
                i++;

            }
            System.out.println("Count i="+i);
        }
        public void cancel(){
            on = false;
        }
    }
}
