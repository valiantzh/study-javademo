package com.study.basis.concurrency.chapter2;

/**
 * 可见性测试
 * @author valiantzh
 * @version 1.0
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread{
        public void run(){
            while(!ready){
                Thread.yield();//暂停当前正在执行的线程对象，并执行其他线程。
            }
            System.out.println(number);
        }
    }
    public static void main(String[] args){
        new ReaderThread().start();
        number = 999;
        ready = true;
    }
}
