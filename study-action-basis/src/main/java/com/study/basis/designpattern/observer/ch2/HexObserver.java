package com.study.basis.designpattern.observer.ch2;

/**
 * @author valiantzh
 * @version 1.0
 */
public class HexObserver extends Observer{
    public HexObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ) );
    }
}
