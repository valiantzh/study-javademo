package com.study.basis.designpattern.state.ch2;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Context {
    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
}
