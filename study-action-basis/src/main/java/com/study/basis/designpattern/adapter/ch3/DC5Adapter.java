package com.study.basis.designpattern.adapter.ch3;

/**
 * 适配器接口
 * @author valiantzh
 * @version 1.0
 */
public interface DC5Adapter {
    boolean support(AC ac);

    int outputDC5V(AC ac);
}
