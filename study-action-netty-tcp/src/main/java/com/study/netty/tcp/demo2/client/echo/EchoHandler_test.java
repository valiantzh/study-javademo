package com.study.netty.tcp.demo2.client.echo;

import com.study.netty.tcp.demo2.User;
import com.study.netty.tcp.demo2.dto.DTObject;
import com.study.netty.tcp.demo2.protocol.TcpProtocol;
import com.study.netty.tcp.demo2.utils.JacksonUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * 粘包,拆包测试
 * @author valiantzh
 * @version 1.0
 */
public class EchoHandler_test extends ChannelInboundHandlerAdapter {
    //连接成功后,发送测试消息
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        User user = new User();
        user.setBirthday(new Date());
        user.setUID(UUID.randomUUID().toString());
        user.setName("xyz");
        user.setAge(24);
        DTObject dtObject = new DTObject();
        dtObject.setClassName(user.getClass().getName());
        dtObject.setObject(JacksonUtils.getInstanceObjectMapper().writeValueAsBytes(user));
        TcpProtocol tcpProtocol = new TcpProtocol();
        byte [] objectBytes= JacksonUtils.getInstanceObjectMapper().writeValueAsBytes(dtObject);
        tcpProtocol.setLen(objectBytes.length);
        tcpProtocol.setData(objectBytes);
        ByteBuf buffer = ctx.alloc().buffer();

        //拆包，只发送一半的数据
        buffer.writeByte(tcpProtocol.getHeader());
        buffer.writeInt(tcpProtocol.getLen());
        buffer.writeBytes(Arrays.copyOfRange(tcpProtocol.getData(),0,tcpProtocol.getLen()/2));
        ctx.write(buffer);
        ctx.flush();

        Thread.sleep(3000);
        //拆包,发送剩余的一半数据
        buffer = ctx.alloc().buffer();
        buffer.writeBytes(Arrays.copyOfRange(tcpProtocol.getData(),tcpProtocol.getLen()/2,tcpProtocol.getLen()));
        buffer.writeByte(tcpProtocol.getTail());

        //模拟粘包的第二帧数据
        buffer.writeByte(tcpProtocol.getHeader());
        buffer.writeInt(tcpProtocol.getLen());
        buffer.writeBytes(tcpProtocol.getData());
        buffer.writeByte(tcpProtocol.getTail());
        //模拟粘包的第三帧数据
        buffer.writeByte(tcpProtocol.getHeader());
        buffer.writeInt(tcpProtocol.getLen());
        buffer.writeBytes(tcpProtocol.getData());
        buffer.writeByte(tcpProtocol.getTail());
        ctx.write(buffer);
        ctx.flush();
    }
}
