package com.study.basis.designpattern.chain.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class MyHandler extends AbstractHandler implements Handler{
    private String name;
    public MyHandler(String name){
        this.name = name;
    }
    @Override
    public void operator() {
        System.out.println(name + " deal!");
        if(getHandler() != null){
            getHandler().operator();
        }
    }
}
