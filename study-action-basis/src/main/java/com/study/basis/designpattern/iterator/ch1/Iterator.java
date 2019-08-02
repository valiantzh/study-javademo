package com.study.basis.designpattern.iterator.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public interface Iterator {
    //前移
    public Object previous();

    //后移
    public Object next();
    public boolean hasNext();

    //取得第一个元素
    public Object first();

}
