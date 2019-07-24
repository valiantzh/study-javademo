package com.study.basis.designpattern.bridge.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class MyBridge extends Bridge{
    public void method(){
        getSource().method();
    }

    /**
     * DEMO
     */
    public static void main(String[] args) {
        Bridge bridge = new MyBridge();

        /*调用第一个对象*/
        Sourceable source1 = new SourceSub1();
        bridge.setSource(source1);
        bridge.method();

        /*调用第二个对象*/
        Sourceable source2 = new SourceSub2();
        bridge.setSource(source2);
        bridge.method();

    }

    /**
     * https://blog.csdn.net/zhangerqing/article/details/8239539
     * 桥接模式就是把事物和其具体实现分开，使他们可以各自独立的变化。
     * 桥接的用意是：将抽象化与实现化解耦，使得二者可以独立变化.
     *
     */
}
