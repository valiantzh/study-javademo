package com.study.netty.tcp.demo2.protocol;

import java.util.Arrays;

/**
 * @author valiantzh
 * @version 1.0
 */
public class TcpProtocol {
    private byte header=0x58;
    private int len;
    private byte [] data;
    private byte tail=0x63;

    public TcpProtocol(){

    }
    public TcpProtocol(int len, byte[] data) {
        this.len =  len;
        this.data = data;
    }

    public byte getHeader() {
        return header;
    }

    public void setHeader(byte header) {
        this.header = header;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
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
        final StringBuilder sb = new StringBuilder("TcpProtocol{");
        sb.append("header=").append(header);
        sb.append(", len=").append(len);
        sb.append(", data=").append(Arrays.toString(data));
        sb.append(", tail=").append(tail);
        sb.append('}');
        return sb.toString();
    }
}
