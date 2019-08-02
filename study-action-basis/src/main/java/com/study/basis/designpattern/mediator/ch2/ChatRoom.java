package com.study.basis.designpattern.mediator.ch2;

import java.util.Date;

/**
 * 中介者类
 * @author valiantzh
 * @version 1.0
 */
public class ChatRoom {
    public static void showMessage(User user, String message){
        System.out.println(new Date().toString()
                + " [" + user.getName() +"] : " + message);
    }
}


