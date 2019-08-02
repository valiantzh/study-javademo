package com.study.basis.designpattern.observer.ch2;

/**
 * @author valiantzh
 * @version 1.0
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
