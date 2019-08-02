package com.study.basis.designpattern.visitor.ch2;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
