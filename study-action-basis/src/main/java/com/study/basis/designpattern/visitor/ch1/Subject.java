package com.study.basis.designpattern.visitor.ch1;

/**
 * Subject接口，accept方法，接受将要访问它的对象，getSubject()获取将要被访问的属性
 * @author valiantzh
 * @version 1.0
 */
public interface Subject {
    public void accept(Visitor visitor);
    public String getSubject();
}
