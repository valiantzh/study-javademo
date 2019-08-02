package com.study.basis.designpattern.memento.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public class Original {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Original(String value) {
        this.value = value;
    }


    public Memento createMemento(){
        return new Memento(value);//Memento 实例 保存value值
    }

    public void restoreMemento(Memento memento){
        this.value = memento.getValue();//恢复为Memento 实例 保存的value值
    }

}
