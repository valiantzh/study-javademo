package com.study.basis.designpattern.bridge.ch1;


/**
 * @author valiantzh
 * @version 1.0
 */
public class SourceSub1 implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is the first sub!");
    }
}
