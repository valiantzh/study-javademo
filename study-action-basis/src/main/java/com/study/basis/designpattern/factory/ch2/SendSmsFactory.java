package com.study.basis.designpattern.factory.ch2;

/**
 * 抽象工厂模式（Abstract Factory）
 * @author valiantzh
 * @version 1.0
 */
public class SendSmsFactory implements Provider{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
