package com.study.basis.designpattern.strategy.ch2;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
