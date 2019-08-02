package com.study.basis.designpattern.memento.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class MementoTest {

    public static void main(String[] args) {
        // 创建原始类
        Original origi = new Original("egg");

        // 创建备忘录
        Storage storage = new Storage(origi.createMemento());

        // 修改原始类的状态
        System.out.println("初始化状态为：" + origi.getValue());
        origi.setValue("niu");
        System.out.println("修改后的状态为：" + origi.getValue());

        // 回复原始类的状态
        origi.restoreMemento(storage.getMemento());
        System.out.println("恢复后的状态为：" + origi.getValue());

    }
    /**
     * https://blog.csdn.net/zhangerqing/article/details/8245537
     * Original类是原始类，里面有需要保存的属性value及创建一个备忘录类，用来保存value值。
     * Memento类是备忘录类，Storage类是存储备忘录的类，持有Memento类的实例
     */
}
