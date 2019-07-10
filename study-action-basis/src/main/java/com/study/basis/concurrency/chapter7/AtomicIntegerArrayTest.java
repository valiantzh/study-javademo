package com.study.basis.concurrency.chapter7;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLongArray;

/**
 * 7.2 原子更新数组
 * AtomicIntegerArray 原子更新整型数组里的元素
 * AtomicLongArray  原子更新长整型数组里的元素
 * AtomicReferenceArray  原子更新引用类型数组里的元素
 * @author valiantzh
 * @version 1.0
 */
public class AtomicIntegerArrayTest {
    static int[] value = new int[] {1,2};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    static long[] lValue = new long[]{100000l,200000l};
    static AtomicLongArray al = new AtomicLongArray(lValue);

    public static void main(String[] args) {
        ai.getAndSet(0,3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);//数组value通过构造方法传递,AtomicIntegerArray会复制一份,不会影响传入的数组

        System.out.println(ai.addAndGet(0,1));//++i
        System.out.println(ai.get(0));

        System.out.println(ai.getAndAdd(0, 1));//i++
        System.out.println(ai.get(0));


    }
}
