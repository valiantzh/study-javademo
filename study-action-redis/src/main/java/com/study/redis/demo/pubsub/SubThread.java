/**
 * 
 * File: SubThread.java <br/>
 * Package: com.study.redis.demo.pubsub <br/>
 * Description:TODO(用一句话描述该文件做什么) <br/>
 * @author zhengxy
 * @Date 2018年10月26日 下午5:03:33
 * @version 1.0
 * 
 */
package com.study.redis.demo.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/** 
 *   
 * @author zhengxy
 * @date 2018年10月26日 下午5:03:33  
 *   
 */
public class SubThread  extends Thread {
    private static Logger log = LoggerFactory.getLogger(SubThread.class);
    private final JedisPool jedisPool;
    private final Subscriber subscriber = new Subscriber();

    private final String channel = "mychannel";

    public SubThread(JedisPool jedisPool) {
        super("SubThread");
        this.jedisPool = jedisPool;
    }

    @Override
    public void run() {
        log.info(String.format("subscribe redis, channel %s, thread will be blocked", channel));
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();   //取出一个连接
            jedis.subscribe(subscriber, channel);    //通过subscribe 的api去订阅，入参是订阅者和频道名
        } catch (Exception e) {
            log.error(String.format("subsrcibe channel error, %s", e));
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    
}
