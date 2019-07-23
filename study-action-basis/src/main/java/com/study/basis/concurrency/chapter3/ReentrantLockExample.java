package com.study.basis.concurrency.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author valiantzh
 * @version 1.0
 */
public class ReentrantLockExample {

    int a = 0;
    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

    }
    public void writer(){
        lock.lock();
        try{
            a++;
        } finally{
            lock.unlock();
        }
    }

    public void reader(){
        lock.lock();
        try{
            int i= a;
            System.out.println("reader:"+i);
        }finally{
            lock.unlock();
        }
    }
}
