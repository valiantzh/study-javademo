package com.study.basis.designpattern.builder.ch2;

/**
 * @author valiantzh
 * @version 1.0
 */
public interface ComputerConfigBuilder {
    void setCPU();
    void setMemory();
    void setHardDisk();
    void setKeyboard();
    void setMouse();
    Computer getComputer();
}
