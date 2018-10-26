/**
 * 
 * File: Subscriber.java <br/>
 * Package: com.study.redis.demo.pubsub <br/>
 * Description:TODO(用一句话描述该文件做什么) <br/>
 * @author zhengxy
 * @Date 2018年10月26日 下午5:01:40
 * @version 1.0
 * 
 */
package com.study.redis.demo.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.JedisPubSub;

/** 
 *   消息订阅
 * @author zhengxy
 * @date 2018年10月26日 下午5:01:40  
 *   
 */
public class Subscriber extends JedisPubSub{
    private Logger log = LoggerFactory.getLogger(this.getClass());
    public Subscriber(){}
    @Override
    public void onMessage(String channel, String message) {       //收到消息会调用
        log.info(String.format("receive redis published message, channel %s, message %s", channel, message));
    }
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {    //订阅了频道会调用
        log.info(String.format("subscribe redis channel success, channel %s, subscribedChannels %d",
                channel, subscribedChannels));
    }
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {   //取消订阅 会调用
        log.info(String.format("unsubscribe redis channel, channel %s, subscribedChannels %d",
                channel, subscribedChannels));

    }
}
