package com.study.basis.designpattern.bridge.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Bridge {

    private Sourceable source;

    public void method(){
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}
