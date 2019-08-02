package com.study.basis.designpattern.chain.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public abstract class AbstractHandler {
    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
