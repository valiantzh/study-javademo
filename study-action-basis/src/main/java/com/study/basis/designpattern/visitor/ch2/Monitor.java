package com.study.basis.designpattern.visitor.ch2;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Monitor implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
