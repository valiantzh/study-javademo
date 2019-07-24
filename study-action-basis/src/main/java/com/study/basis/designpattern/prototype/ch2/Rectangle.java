package com.study.basis.designpattern.prototype.ch2;

/**
 * 长方形
 * @author valiantzh
 * @version 1.0
 */
public class Rectangle extends Shape{
    public Rectangle(){
        type = "Rectangle";
    }
    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
