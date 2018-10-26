/**
 * 
 * File: PubSubDemo.java <br/>
 * Package: com.study.redis.demo.pubsub <br/>
 * Description:TODO(用一句话描述该文件做什么) <br/>
 * @author zhengxy
 * @Date 2018年10月26日 下午5:04:19
 * @version 1.0
 * 
 */
package com.study.redis.demo.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/** 
 *   
 * @author zhengxy
 * @date 2018年10月26日 下午5:04:19  
 *   
 */
public class PubSubDemo {
    private static Logger log = LoggerFactory.getLogger(PubSubDemo.class);
    /**  
     * @Title: main  
     * @Description: TODO(这里用一句话描述这个方法的作用)  
     * @param args  
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // 连接redis服务端
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
        
        log.info(String.format("redis pool is starting, redis ip %s, redis port %d", "127.0.0.1", 6379));

        SubThread subThread = new SubThread(jedisPool);  //订阅者
        subThread.start();

        Publisher publisher = new Publisher(jedisPool);    //发布者
        publisher.start();
    }
    
}
