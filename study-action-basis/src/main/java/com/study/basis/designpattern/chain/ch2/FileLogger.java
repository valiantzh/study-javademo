package com.study.basis.designpattern.chain.ch2;

/**
 * @author valiantzh
 * @version 1.0
 */
public class FileLogger extends AbstractLogger{

    public FileLogger(int level){
        this.level = level;
    }
    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
