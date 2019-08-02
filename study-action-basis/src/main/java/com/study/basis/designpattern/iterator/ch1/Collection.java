package com.study.basis.designpattern.iterator.ch1;

/**
 * @author valiantzh
 * @version 1.0
 */
public interface Collection {
    public Iterator iterator();

    /*取得集合元素*/
    public Object get(int i);

    /*取得集合大小*/
    public int size();

}
