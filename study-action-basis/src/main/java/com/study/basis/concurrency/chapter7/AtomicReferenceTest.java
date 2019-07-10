package com.study.basis.concurrency.chapter7;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 7.3 原子更新引用类型
 * AtomicReference 原子更新引用类型
 * AtomicReferenceFieldUpdater 原子更新引用类型里的字段
 * AtomicMarkableReference 原子更新带标记位的引用类型
 * @author valiantzh
 * @version 1.0
 */
public class AtomicReferenceTest {
    public static AtomicReference<User> atomicUserRef = new AtomicReference<>();
    public static void main(String[] args) {
        User user = new User("zxy", 18);
        atomicUserRef.set(user);

        User updateUser = new User("zxy",28);

        atomicUserRef.compareAndSet(user, updateUser);
        System.out.println(atomicUserRef.get().getName());
        System.out.println(atomicUserRef.get().getOld());

    }

    static class User{
        private String name;
        private int old;
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
