package com.study.netty.tcp.demo2.client.echo;

import com.study.netty.tcp.demo2.User;
import com.study.netty.tcp.demo2.protocol.TcpProtocol_2_0;
import com.study.netty.tcp.demo2.utils.ProtocolUtils_2_0;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author valiantzh
 * @version 1.0
 */
public class EchoHandler_2_0 extends ChannelInboundHandlerAdapter {
    //连接成功后发送消息测试
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        User user = new User();
        user.setBirthday(new Date());
        user.setUID(UUID.randomUUID().toString());
        user.setName("xyz");
        user.setAge(20);
        HashMap<String, User> map = new HashMap<>();
        map.put("数据一",user);
        map.put("数据2",user);
        map.put("数据3",user);
        ArrayList<User> list = new ArrayList<>();
        list.add(user);
        list.add(user);
        list.add(user);
        list.add(user);
        TcpProtocol_2_0 tcpProtocol= ProtocolUtils_2_0.prtclInstance(map,user.getClass().getName());
        ctx.write(tcpProtocol);
        ctx.flush();
    }
}
