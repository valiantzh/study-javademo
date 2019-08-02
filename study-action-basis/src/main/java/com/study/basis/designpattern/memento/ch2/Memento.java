package com.study.basis.designpattern.memento.ch2;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
