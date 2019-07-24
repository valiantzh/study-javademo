package com.study.basis.designpattern.prototype.ch2;

/**
 * 圆形
 * @author valiantzh
 * @version 1.0
 */
public class Circle extends Shape{
    public Circle(){
        type = "Circle";
    }
    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
