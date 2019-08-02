package com.study.basis.designpattern.command.ch1;

import org.apache.commons.lang3.StringUtils;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Receiver {
    public void action(String cmd){
        if(StringUtils.isNotBlank(cmd)){
            System.out.println("command received![" + cmd+"]");
        }
    }
}
