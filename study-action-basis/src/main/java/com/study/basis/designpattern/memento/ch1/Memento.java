package com.study.basis.designpattern.memento.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Memento {
    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
