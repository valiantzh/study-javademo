package com.study.netty.tcp.demo2.client.echo;

import com.study.netty.tcp.demo2.User;
import com.study.netty.tcp.demo2.protocol.TcpProtocol_3_0;
import com.study.netty.tcp.demo2.utils.ProtocolUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.*;

/**
 * @author valiantzh
 * @version 1.0
 */
public class EchoHandler_3_0 extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        User user = new User();
        user.setBirthday(new Date());
        user.setUID(UUID.randomUUID().toString());
        user.setName("xyz");
        user.setAge(30);
        Map<String,User> map=new HashMap<>();
        map.put("数据一",user);
        List<User> users=new ArrayList<>();
        users.add(user);
        TcpProtocol_3_0 protocol = ProtocolUtils.prtclInstance(map,user.getClass().getName());
        //传map
        ctx.write(protocol);//由于设置了编码器，这里直接传入自定义的对象
        ctx.flush();
        //传list
        ctx.write(ProtocolUtils.prtclInstance(users,user.getClass().getName()));
        ctx.flush();
        //传单一实体
        ctx.write(ProtocolUtils.prtclInstance(user));
        ctx.flush();
    }
}
