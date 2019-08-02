package com.study.basis.designpattern.interpreter.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Plus implements Expression{
    @Override
    public int interpret(Context context) {
        return context.getNum1()+context.getNum2();
    }
}
