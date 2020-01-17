package com.study.netty.tcp.demo2.server.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.netty.tcp.demo2.dto.DTObject;
import com.study.netty.tcp.demo2.utils.JacksonUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * @author valiantzh
 * @version 1.0
 */
public class BusinessHandler_2_0 extends ChannelInboundHandlerAdapter {
    private Logger logger = Logger.getLogger(this.getClass());
    private ObjectMapper objectMapper= JacksonUtils.getInstanceObjectMapper();
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof List){
            logger.info("这是一个List:"+(List)msg);
        }else if (msg instanceof Map){
            logger.info("这是一个Map:"+(Map)msg);
        }else{
            logger.info("这是一个对象："+msg.getClass().getName());
            logger.info("这是一个对象："+msg);
        }
    }
}
