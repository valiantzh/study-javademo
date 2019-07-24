package com.study.basis.designpattern.prototype.ch2;

/**
 * 正方形
 * @author valiantzh
 * @version 1.0
 */
public class Square extends Shape{
    public Square(){
        type = "Square";
    }
    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
