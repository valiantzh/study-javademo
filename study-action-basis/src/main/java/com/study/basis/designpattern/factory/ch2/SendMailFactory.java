package com.study.basis.designpattern.factory.ch2;

/**
 * 抽象工厂模式（Abstract Factory）
 * @author valiantzh
 * @version 1.0
 */
public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }

    public static void main(String[] args) {
        Provider provider = new SendSmsFactory();
        Sender sender = provider.produce();
        sender.send();
    }
}
