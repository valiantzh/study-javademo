package com.study.basis.designpattern.visitor.ch2;

/**
 * 表示访问者的接口。
 * @author valiantzh
 * @version 1.0
 */
public interface ComputerPartVisitor {
    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);
}
