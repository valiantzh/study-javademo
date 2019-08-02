package com.study.basis.designpattern.mediator.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class User2 extends User {
    public User2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user 2 exe");
    }
}
