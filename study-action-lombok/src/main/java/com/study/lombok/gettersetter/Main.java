package com.study.lombok.gettersetter;


import lombok.extern.slf4j.Slf4j;

/**
 * @author valiantzh
 * @version 1.0
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setId("1");
        user.setName("valiantzh");
        user.setAge(100);
        System.out.println(user.getName());
        System.out.println(user.toString());

        // @Accessors(chain = true)
        User userChain = new User();
        userChain.setId("2").setName("chain").setAge(18);
        System.out.println(userChain.getName());
        log.info(userChain.getName());
    }
}
