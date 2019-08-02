package com.study.basis.designpattern.mediator.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class User1 extends User {
    public User1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("user 1 exe");
    }
}
