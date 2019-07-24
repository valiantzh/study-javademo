package com.study.basis.designpattern.adapter.ch3;

import java.util.LinkedList;
import java.util.List;

/**
 * @author valiantzh
 * @version 1.0
 */
public class DC5AdapterTest {
    private static List<DC5Adapter> adapters = new LinkedList<DC5Adapter>();
    public static void loadAdapter(){
        adapters.add(new ChinaPowerAdapter());
        adapters.add(new JapanPowerAdapter());
    }
    // 根据电压找合适的变压器
    public static DC5Adapter getPowerAdapter(AC ac) {
        DC5Adapter adapter = null;
        for (DC5Adapter ad : adapters) {
            if (ad.support(ac)) {
                adapter = ad;
                break;
            }
        }
        if (adapter == null){
            throw new  IllegalArgumentException("没有找到合适的变压适配器");
        }
        return adapter;
    }
    public static void main(String[] args) {
        DC5AdapterTest.loadAdapter();
        AC chinaAC = new AC220();
        DC5Adapter adapter = DC5AdapterTest.getPowerAdapter(chinaAC);
        adapter.outputDC5V(chinaAC);

        // 去日本旅游，电压是 110V
        AC japanAC = new AC110();
        adapter = DC5AdapterTest.getPowerAdapter(japanAC);
        adapter.outputDC5V(japanAC);
    }
    /*
    适配器模式总结
    主要优点：
将目标类和适配者类解耦，通过引入一个适配器类来重用现有的适配者类，无须修改原有结构。
增加了类的透明性和复用性，将具体的业务实现过程封装在适配者类中，对于客户端类而言是透明的，而且提高了适配者的复用性，同一个适配者类可以在多个不同的系统中复用。
灵活性和扩展性都非常好，通过使用配置文件，可以很方便地更换适配器，也可以在不修改原有代码的基础上增加新的适配器类，完全符合“开闭原则”。
具体来说，类适配器模式还有如下优点：

由于适配器类是适配者类的子类，因此可以在适配器类中置换一些适配者的方法，使得适配器的灵活性更强。
对象适配器模式还有如下优点：

一个对象适配器可以把多个不同的适配者适配到同一个目标；
可以适配一个适配者的子类，由于适配器和适配者之间是关联关系，根据“里氏代换原则”，适配者的子类也可通过该适配器进行适配。
类适配器模式的缺点如下：

对于Java、C#等不支持多重类继承的语言，一次最多只能适配一个适配者类，不能同时适配多个适配者；
适配者类不能为最终类，如在Java中不能为final类，C#中不能为sealed类；
在Java、C#等语言中，类适配器模式中的目标抽象类只能为接口，不能为类，其使用有一定的局限性。
对象适配器模式的缺点如下：

与类适配器模式相比，要在适配器中置换适配者类的某些方法比较麻烦。如果一定要置换掉适配者类的一个或多个方法，可以先做一个适配者类的子类，将适配者类的方法置换掉，然后再把适配者类的子类当做真正的适配者进行适配，实现过程较为复杂。
适用场景：

系统需要使用一些现有的类，而这些类的接口（如方法名）不符合系统的需要，甚至没有这些类的源代码。
想创建一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类，包括一些可能在将来引进的类一起工作。
     */
}
