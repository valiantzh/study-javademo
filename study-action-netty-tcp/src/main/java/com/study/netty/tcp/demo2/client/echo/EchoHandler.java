package com.study.netty.tcp.demo2.client.echo;

import com.study.netty.tcp.demo2.User;
import com.study.netty.tcp.demo2.dto.DTObject;
import com.study.netty.tcp.demo2.protocol.TcpProtocol;
import com.study.netty.tcp.demo2.utils.JacksonUtils;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;
import java.util.UUID;

/**
 * @author valiantzh
 * @version 1.0
 */
public class EchoHandler extends ChannelInboundHandlerAdapter {
    //连接成功后,发送测试消息
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        User user = new User();
        user.setBirthday(new Date());
        user.setUID(UUID.randomUUID().toString());
        user.setName("xyz");
        user.setAge(22);
        DTObject dtObject = new DTObject();
        dtObject.setClassName(user.getClass().getName());
        dtObject.setObject(JacksonUtils.getInstanceObjectMapper().writeValueAsBytes(user));
        TcpProtocol tcpProtocol = new TcpProtocol();
        byte [] objectBytes= JacksonUtils.getInstanceObjectMapper().writeValueAsBytes(dtObject);
        tcpProtocol.setLen(objectBytes.length);
        tcpProtocol.setData(objectBytes);
        ctx.write(tcpProtocol);//设置了编码器，可以直接传入自定义的对象
        ctx.flush();
    }
}
