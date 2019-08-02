package com.study.basis.designpattern.strategy.ch2;

/**
 * @author valiantzh
 * @version 1.0
 */
public class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
