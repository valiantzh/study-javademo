package com.study.basis.designpattern.adapter.ch3;

/**
 * 输出220V交流电压类
 * @author valiantzh
 * @version 1.0
 */
public class AC220 implements AC{
    public final int output = 220;

    @Override
    public int outputAC() {
        return output;
    }
}
