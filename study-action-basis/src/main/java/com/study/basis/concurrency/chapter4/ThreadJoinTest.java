package com.study.basis.concurrency.chapter4;

import com.study.basis.utils.SleepUtils;

/**
 * Join
 * 一个线程A调用thread.join(),当前A线程等待thread线程终止之后才从thread.join()返回.
 * @author valiantzh
 * @version 1.0
 */
public class ThreadJoinTest {

    public static void main(String[] args) {
        Thread previous = Thread.currentThread();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous =  thread;
        }
        SleepUtils.second(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");

    }
    static class Domino implements Runnable{
        private Thread thread;

        public Domino(Thread thread){
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}
