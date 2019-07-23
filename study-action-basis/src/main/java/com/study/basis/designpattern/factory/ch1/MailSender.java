package com.study.basis.designpattern.factory.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("This is MailSender.");
    }
}
