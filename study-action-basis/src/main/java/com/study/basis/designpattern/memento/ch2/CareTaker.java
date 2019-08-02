package com.study.basis.designpattern.memento.ch2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author valiantzh
 * @version 1.0
 */
public class CareTaker {

    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}
