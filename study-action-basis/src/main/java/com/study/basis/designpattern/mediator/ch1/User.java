package com.study.basis.designpattern.mediator.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public abstract class User {
    private Mediator mediator;

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public abstract void work();
}
