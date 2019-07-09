package com.study.basis.concurrency.chapter1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class DeadLockDemo {
    private static String A = "A";
    private static String B = "B";
    public static void main(String[] args){
        new DeadLockDemo().deadLock();
    }
    private void deadLock(){
        Thread th1= new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(A){
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized(B){
                        System.out.println("11");
                    }

                }
            }
        });

        Thread th2 = new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(B){
                    synchronized(A){
                        System.out.println("2");
                    }
                }
            }
        });

        th1.start();
        th2.start();
    }
}
