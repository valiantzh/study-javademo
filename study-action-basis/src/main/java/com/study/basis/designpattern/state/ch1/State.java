package com.study.basis.designpattern.state.ch1;

/**
 * 状态类的核心类
 * @author valiantzh
 * @version 1.0
 */
public class State {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void method1(){
        System.out.println("execute the first method!");
    }

    public void method2(){
        System.out.println("execute the second method!");
    }

}
