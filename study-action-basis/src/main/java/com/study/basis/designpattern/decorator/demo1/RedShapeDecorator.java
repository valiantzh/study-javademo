package com.study.basis.designpattern.decorator.demo1;

public class RedShapeDecorator extends ShapeDecorator{

    /**  
     *   
     * @param decoratedShape  
     */
    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }
    
    @Override
    public void draw() {
       decoratedShape.draw();         
       setRedBorder(decoratedShape);
    }
  
    private void setRedBorder(Shape decoratedShape){
       System.out.println("Border Color: Red");
    }
}
