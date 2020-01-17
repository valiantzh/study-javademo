package com.study.netty.tcp.demo2.protocol;

import java.util.Arrays;

/**
 * type      0x51    0x52    0x53
 * mean      object  list    map
 * @author valiantzh
 * @version 1.0
 */
public class TcpProtocol_3_0 {
    private byte header=0x58;
    private byte type;
    private byte classLen;
    private int len;
    private byte[] className;
    private byte [] data;
    private byte tail=0x63;
    public TcpProtocol_3_0() {
    }
    public TcpProtocol_3_0(int len, byte[] data) {
        this.len = len;
        this.data = data;
    }

    public TcpProtocol_3_0(byte type, byte classLen, int len, byte[] className, byte[] data) {
        this.type = type;
        this.classLen = classLen;
        this.len = len;
        this.className = className;
        this.data = data;
    }


    public byte getHeader() {
        return header;
    }

    public void setHeader(byte header) {
        this.header = header;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getClassLen() {
        return classLen;
    }

    public void setClassLen(byte classLen) {
        this.classLen = classLen;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getClassName() {
        return className;
    }

    public void setClassName(byte[] className) {
        this.className = className;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte getTail() {
        return tail;
    }

    public void setTail(byte tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TcpProtocol_3_0{");
        sb.append("header=").append(header);
        sb.append(", type=").append(type);
        sb.append(", classLen=").append(classLen);
        sb.append(", len=").append(len);
        sb.append(", className=").append(Arrays.toString(className));
        sb.append(", data=").append(Arrays.toString(data));
        sb.append(", tail=").append(tail);
        sb.append('}');
        return sb.toString();
    }
}
