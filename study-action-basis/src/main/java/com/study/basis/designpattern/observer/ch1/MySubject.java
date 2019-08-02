package com.study.basis.designpattern.observer.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class MySubject extends AbstractSubject{
    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }
}
