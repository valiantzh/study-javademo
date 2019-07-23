package com.study.basis.designpattern.factory.ch1;

/**
 * 普通工厂类
 * @author valiantzh
 * @version 1.0
 */
public class SendFactory {
    public Sender produce(String type){
        if("mail".equalsIgnoreCase(type)) {
            return new MailSender();
        } else if("sms".equalsIgnoreCase(type)){
            return new SmsSender();
        }else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }

    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        String type = "Mail";
        //Sender sender = factory.produce("sms");
        Sender sender = factory.produce(type);
        if(sender != null) {
            sender.send();
        }
    }
}
