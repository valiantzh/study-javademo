package com.study.netty.tcp.demo3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;

import java.net.InetAddress;

/**
 * @author valiantzh
 * @version 1.0
 */
public class DiscardServerHandler extends SimpleChannelInboundHandler<Object> {
    private static final Logger logger = Logger.getLogger(DiscardServerHandler.class);
    // 从客户端接收到的消息
    /*
     *  服务器向指定客户端发送消息,只需要通过`map`将客户端的`id`和`channel`存起来
     *  在需要的时候通过`writeAndFlush`方法发送即可
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端地址:"+ctx.channel().remoteAddress()+",消息:"+new String(msg.toString().getBytes()));
        //ctx.writeAndFlush("client Msg:"+new String(msg.toString().getBytes()));
   }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
    /*
     * 建立连接时，返回消息
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //System.out.println("连接的客户端地址:" + ctx.channel().remoteAddress());
        logger.info("连接的客户端地址:" + ctx.channel().remoteAddress());
        logger.info("连接的客户端ID:" + ctx.channel().id());
        ctx.writeAndFlush("client"+ InetAddress.getLocalHost().getHostName() + "success connected！ \n");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("断开连接的客户端ID:" + ctx.channel().id());
        super.channelInactive(ctx);
    }
}
