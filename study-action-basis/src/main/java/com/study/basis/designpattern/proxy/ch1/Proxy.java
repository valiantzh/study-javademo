package com.study.basis.designpattern.proxy.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Proxy implements Sourceable{
    private Source source;

    public Proxy(){
        super();
        this.source = new Source();
    }
    @Override
    public void method() {
        before();
        this.source.method();
        after();
    }

    private void after() {
        System.out.println("after proxy!");
    }
    private void before() {
        System.out.println("before proxy!");
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        Sourceable source = new Proxy();
        source.method();
    }

    /**
     * https://blog.csdn.net/zhangerqing/article/details/8239539
     *
     * 代理模式的应用场景：
     *
     * 如果已有的方法在使用的时候需要对原有的方法进行改进，此时有两种办法：
     *
     * 1、修改原有的方法来适应。这样违反了“对扩展开放，对修改关闭”的原则。
     *
     * 2、就是采用一个代理类调用原有的方法，且对产生的结果进行控制。这种方法就是代理模式。
     *
     * 使用代理模式，可以将功能划分的更加清晰，有助于后期维护！
     */
}
