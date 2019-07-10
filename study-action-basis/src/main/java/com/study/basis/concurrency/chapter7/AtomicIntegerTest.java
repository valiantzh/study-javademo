package com.study.basis.concurrency.chapter7;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 7.1 原子更新基本类型
 * AtomicInteger  原子更新整型
 * AtomicBoolean 原子更新布尔类型
 * AtomicLong 原子更新长整型
 * @author valiantzh
 * @version 1.0
 */
public class AtomicIntegerTest {
    static AtomicInteger aInteger = new AtomicInteger(1);
    static AtomicLong aLong = new AtomicLong(9l);

    static AtomicBoolean aBoolean = new AtomicBoolean(true);
    public static void main(String[] args){
        //Integer
        System.out.println(aInteger.getAndIncrement());//i++
        System.out.println(aInteger.get());

        //Long
        System.out.println(aLong.addAndGet(100));
        System.out.println(aLong.floatValue());
        System.out.println(aLong.decrementAndGet());
        System.out.println(aLong.getAndDecrement());
        System.out.println(aLong.getAndIncrement());
        System.out.println(aLong.getAndAdd(100));
        System.out.println(aLong.getAndSet(10000));
        //boolean
        System.out.println(aBoolean.compareAndSet(true, false));
        System.out.println(aBoolean.get());

    }
}
