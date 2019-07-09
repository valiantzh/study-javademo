package com.study.basis.concurrency.chapter7;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author valiantzh
 * @version 1.0
 */
public class AtomicIntegerTest {
    static AtomicInteger ai = new AtomicInteger(1);
    public static void main(String[] args){
        System.out.println(ai.getAndIncrement());//i++
        System.out.println(ai.get());
    }
}
