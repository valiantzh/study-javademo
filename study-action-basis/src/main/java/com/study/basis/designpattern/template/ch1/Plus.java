package com.study.basis.designpattern.template.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Plus extends AbstractCalculator{
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }

    /**
     * DEMO
     */
    public static void main(String[] args) {
        String exp = "8+8";
        AbstractCalculator cal = new Plus();
        int result = cal.calculate(exp, "\\+");
        System.out.println(exp+"="+result);

    }

    /**
     * https://blog.csdn.net/zhangerqing/article/details/8243942
     * 一个抽象类中，有一个主方法，再定义1...n个方法，可以是抽象的，也可以是实际的方法，定义一个类，继承该抽象类，重写抽象方法，通过调用抽象类，实现对子类的调用
     */
}
