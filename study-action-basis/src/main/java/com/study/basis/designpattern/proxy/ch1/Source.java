package com.study.basis.designpattern.proxy.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Source implements Sourceable{
    @Override
    public void method() {
        System.out.println("the orignal method.");
    }
}
