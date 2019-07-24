package com.study.basis.designpattern.decorator.ch2;


/**
 *实现了 Shape 接口的抽象装饰类 ShapeDecorator，并把 Shape 对象作为它的实例变量。
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;
    
    public ShapeDecorator(Shape decoratedShape){
       this.decoratedShape = decoratedShape;
    }
    @Override
    public void draw() {
        decoratedShape.draw();
    }
    
}
