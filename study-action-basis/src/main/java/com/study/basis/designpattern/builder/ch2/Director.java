package com.study.basis.designpattern.builder.ch2;

/**
 * 装机人员Director
 * @author valiantzh
 * @version 1.0
 */
public class Director {
    private ComputerConfigBuilder mBuilder;
    public void setBuilder(ComputerConfigBuilder builder){
        this.mBuilder = builder;
    }
    public void createComputer(){
        mBuilder.setCPU();
        mBuilder.setMemory();
        mBuilder.setHardDisk();
        mBuilder.setKeyboard();
        mBuilder.setMouse();
    }
    public Computer getComputer(){
        return mBuilder.getComputer();
    }

    public static void main(String[] args) {
        Director director = new Director();//创建装机人员
        director.setBuilder(new LowConfigBuilder()); //告诉装机人员电脑配置，这里为低配版
        director.createComputer(); //装机人员开始组装
        Computer computer = director.getComputer(); //从装机人员获取组装好的电脑
        System.out.print("电脑配置：" + computer.toString());  //查看电脑配置
    }
}
