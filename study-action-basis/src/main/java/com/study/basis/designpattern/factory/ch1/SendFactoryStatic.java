package com.study.basis.designpattern.factory.ch1;

/**
 * 静态工厂方法模式
 * @author valiantzh
 * @version 1.0
 */
public class SendFactoryStatic {
    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }

    public static void main(String[] args) {
        Sender sender = SendFactoryStatic.produceMail();
        sender.send();
    }
}
