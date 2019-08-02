package com.study.basis.designpattern.chain.ch2;

/**
 * @author valiantzh
 * @version 1.0
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
