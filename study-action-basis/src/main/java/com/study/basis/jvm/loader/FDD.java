package com.study.basis.jvm.loader;

/**
 * @author valiantzh
 * @version 1.0
 */
public class FDD {
    static {
        System.out.println("静态代码块");
    }

    public void sayHello(String name) {
        System.out.println("FDD say hello, "+name);
    }
}
