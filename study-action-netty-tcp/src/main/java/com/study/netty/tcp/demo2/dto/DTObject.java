package com.study.netty.tcp.demo2.dto;

import java.util.Arrays;

/**
 * @author valiantzh
 * @version 1.0
 */
public class DTObject {
    private String className;
    private byte[] object;



    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public byte[] getObject() {
        return object;
    }

    public void setObject(byte[] object) {
        this.object = object;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DTObject{");
        sb.append("className='").append(className).append('\'');
        sb.append(", object=").append(Arrays.toString(object));
        sb.append('}');
        return sb.toString();
    }
}
