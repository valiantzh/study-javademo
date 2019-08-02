package com.study.basis.designpattern.state.ch2;

/**
 * @author valiantzh
 * @version 1.0
 */
public class StopState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString(){
        return "Stop State";
    }
}
