package com.study.lombok.builder;


/**
 * @author valiantzh
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // @Builder
        User userBuilder = User.builder().id("3").name("builder").age(5).build();
        System.out.println(userBuilder.getName());
    }
}
