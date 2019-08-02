package com.study.basis.designpattern.strategy.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Minus extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"-");
        return arrayInt[0]-arrayInt[1];
    }
}
