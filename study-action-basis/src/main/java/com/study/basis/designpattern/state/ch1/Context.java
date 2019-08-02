package com.study.basis.designpattern.state.ch1;

/**
 * 状态模式的切换类
 * @author valiantzh
 * @version 1.0
 */
public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void method(){
        if (state.getValue().equals("state1")) {
            state.method1();
        } else if (state.getValue().equals("state2")) {
            state.method2();
        }

    }
}
