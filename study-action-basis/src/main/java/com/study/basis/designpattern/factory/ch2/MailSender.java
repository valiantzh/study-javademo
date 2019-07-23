package com.study.basis.designpattern.factory.ch2;

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
