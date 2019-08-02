package com.study.basis.designpattern.visitor.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class MySubject implements Subject {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return "love";
    }
}
