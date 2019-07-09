package com.study.lombok.demo;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setId("1");
        user.setName("valiantzh");
        user.setAge(100);
        System.out.println(user.getName());
    }
}
