package com.study.basis.designpattern.command.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class MyCommand implements Command{
    private Receiver receiver;
    private String cmd;

    public MyCommand(Receiver receiver, String cmd){
        this.receiver = receiver;
        this.cmd = cmd;
    }
    @Override
    public void exe() {
        receiver.action(cmd);
    }

}
