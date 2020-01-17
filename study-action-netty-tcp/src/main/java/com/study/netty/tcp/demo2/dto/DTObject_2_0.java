package com.study.netty.tcp.demo2.dto;

/**
 * @author valiantzh
 * @version 1.0
 */
public class DTObject_2_0<T> {
    private String className;
    private T object;

    public DTObject_2_0(String className, T object) {
        this.className = className;
        this.object = object;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DTObject_2_0{");
        sb.append("className='").append(className).append('\'');
        sb.append(", object=").append(object);
        sb.append('}');
        return sb.toString();
    }
}
