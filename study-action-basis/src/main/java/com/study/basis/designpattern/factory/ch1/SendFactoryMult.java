package com.study.basis.designpattern.factory.ch1;

/**
 * 多个工厂方法模式
 * 在普通工厂方法模式中，如果传递的字符串出错，则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法，分别创建对象。
 * @author valiantzh
 * @version 1.0
 */
public class SendFactoryMult {
    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms() {
        return new SmsSender();
    }

    public static void main(String[] args) {
        SendFactoryMult factory = new SendFactoryMult();
        Sender sender = factory.produceMail();
        sender.send();
    }
}
