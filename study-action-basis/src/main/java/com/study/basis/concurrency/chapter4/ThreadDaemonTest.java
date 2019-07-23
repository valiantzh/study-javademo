package com.study.basis.concurrency.chapter4;

import com.study.basis.utils.SleepUtils;

/**
 * 守护线程,
 * 当一个JVM中无Daemon线程时,JVM将退出
 * @author valiantzh
 * @version 1.0
 */
public class ThreadDaemonTest {

    public static void main(String[] args) {
        Thread td = new Thread(new DaemonRunner(), "DaemonRunner");
        td.setDaemon(true);
        td.start();
    }
    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try{
                System.out.println("DaemonRunner run.");
                SleepUtils.second(10);
            }finally{
                //Deamon线程中finally块不一定执行
                System.out.println("DeamonThread finally run.");
            }
        }
    }

}
