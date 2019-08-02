package com.study.basis.designpattern.command.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Invoker {

    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public void action(){
        command.exe();
    }
}
