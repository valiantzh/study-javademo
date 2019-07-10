package com.study.basis.concurrency.chapter7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 7.4原子更新字段类
 *
 * AtomicIntegerFieldUpdater 原子更新整型字段的更新器
 * AtomicLongFieldUpdater  原子更新长整型字段的更新器
 * AtomicStampedReference  原子更新带版本号的引用类型.可以解决CAS进行原子更新时可能出现的ABA问题
 * @author valiantzh
 * @version 1.0
 */
public class AtomicIntegerFieldUpdaterTest {
    //创建原子更新器,并设置需要更新的对象类和对象的属性
    private static AtomicIntegerFieldUpdater<User> a= AtomicIntegerFieldUpdater
            .newUpdater(User.class, "old");
    public static void main(String[] args) {
        User conan =  new User("conan", 10);
        System.out.println(a.getAndIncrement(conan));
        System.out.println(a.get(conan));
    }

    public static class User{
        private String name;
        public volatile int old; //更新类的字段必须使用public volatile修饰
        public User(String name, int old){
            this.name = name;
            this.old  = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }
}
