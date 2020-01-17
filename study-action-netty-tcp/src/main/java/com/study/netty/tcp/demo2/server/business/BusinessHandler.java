package com.study.netty.tcp.demo2.server.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.netty.tcp.demo2.dto.DTObject;
import com.study.netty.tcp.demo2.utils.JacksonUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;

/**
 * 业务处理类 消息处理
 * @author valiantzh
 * @version 1.0
 */
public class BusinessHandler extends ChannelInboundHandlerAdapter {
    private Logger logger = Logger.getLogger(this.getClass());
    private ObjectMapper objectMapper= JacksonUtils.getInstanceObjectMapper();
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof byte []){
            logger.debug("解码后的字节码："+new String((byte[]) msg,"UTF-8"));
            try {
                Object objectContainer = objectMapper.readValue((byte[]) msg, DTObject.class);
                if (objectContainer instanceof DTObject){
                    DTObject data = (DTObject) objectContainer;
                    if (data.getClassName()!=null&&data.getObject().length>0){
                        Object object = objectMapper.readValue(data.getObject(), Class.forName(data.getClassName()));
                        logger.info("收到实体对象："+object);
                    }
                }
            }catch (Exception e){
                logger.info("对象反序列化出现问题："+e);
            }

        }
    }
}
