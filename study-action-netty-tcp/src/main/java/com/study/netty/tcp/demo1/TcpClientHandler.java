package com.study.netty.tcp.demo1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author valiantzh
 * @version 1.0
 */
public class TcpClientHandler extends SimpleChannelInboundHandler<Object> {
    // 从服务器接收到的信息 `Object`
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println(new String(msg.toString().getBytes()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
