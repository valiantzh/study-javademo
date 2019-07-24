package com.study.basis.designpattern.adapter.ch1;

/**
 * 对象的适配器模式
 * 基本思路和类的适配器模式相同，只是将Adapter类作修改，
 * 不继承Source类，而是持有Source类的实例，以达到解决兼容性的问题。
 * @author valiantzh
 * @version 1.0
 */
public class Wrapper implements Targetable {
    private Source source;
    public Wrapper(Source source) {
        super();
        this.source = source;
    }
    @Override
    public void method1() {
        System.out.println("this is the targetable method!");
    }

    @Override
    public void method2() {
        source.method1();
    }

    public static void main(String[] args) {
        Source source = new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();
    }
}
