package com.study.basis.designpattern.visitor.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class MyVisitor implements Visitor {
    @Override
    public void visit(Subject sub) {
        System.out.println("visit the subject："+sub.getSubject());
    }
}
