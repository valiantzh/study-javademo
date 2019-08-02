package com.study.basis.designpattern.observer.ch1;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author valiantzh
 * @version 1.0
 */
public abstract class AbstractSubject implements Subject{
    private Vector<Observer> vector = new Vector<Observer>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enume = vector.elements();
        while(enume.hasMoreElements()){
            enume.nextElement().update();
        }

    }
}
