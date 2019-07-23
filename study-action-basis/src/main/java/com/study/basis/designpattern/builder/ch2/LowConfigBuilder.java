package com.study.basis.designpattern.builder.ch2;

/**
 * 低配版配置
 * @author valiantzh
 * @version 1.0
 */
public class LowConfigBuilder implements ComputerConfigBuilder{
    private Computer mComputer;
    public LowConfigBuilder(){
        mComputer = new Computer();
    }
    @Override
    public void setCPU() {
        mComputer.setCPU("i5");
    }

    @Override
    public void setMemory() {
        mComputer.setMemory("8G");
    }

    @Override
    public void setHardDisk() {
        mComputer.setHardDisk("500G");
    }

    @Override
    public void setKeyboard() {
        mComputer.setKeyboard("薄膜键盘");
    }

    @Override
    public void setMouse() {
        mComputer.setMouse("有线鼠标");
    }

    @Override
    public Computer getComputer() {
        return mComputer;
    }
}
