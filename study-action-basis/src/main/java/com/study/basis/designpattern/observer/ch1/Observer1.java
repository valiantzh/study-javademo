package com.study.basis.designpattern.observer.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Observer1 implements Observer {
    @Override
    public void update() {
        System.out.println("observer1 has received!");
    }
}
