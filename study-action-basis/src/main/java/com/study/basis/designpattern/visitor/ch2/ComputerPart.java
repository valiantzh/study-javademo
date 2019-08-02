package com.study.basis.designpattern.visitor.ch2;

/**
 * 表示元素的接口。
 * @author valiantzh
 * @version 1.0
 */
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
