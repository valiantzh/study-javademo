package com.study.basis.designpattern.bridge.ch2;

/**
 * 使用 DrawAPI 接口创建抽象类 Shape。
 * @author valiantzh
 * @version 1.0
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
