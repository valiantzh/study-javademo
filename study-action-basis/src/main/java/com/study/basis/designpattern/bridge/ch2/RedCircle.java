package com.study.basis.designpattern.bridge.ch2;

/**
 * 创建实现了 DrawAPI 接口的实体桥接实现类。
 * @author valiantzh
 * @version 1.0
 */
public class RedCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
