package com.study.basis.designpattern.adapter.ch3;

/**
 * 输出110V交流电压类
 * @author valiantzh
 * @version 1.0
 */
public class AC110 implements AC{
    public final int output = 110;

    @Override
    public int outputAC() {
        return output;
    }
}
