package com.study.basis.designpattern.chain.ch2;

/**
 * @author valiantzh
 * @version 1.0
 */
public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level){
        this.level = level;
    }
    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
