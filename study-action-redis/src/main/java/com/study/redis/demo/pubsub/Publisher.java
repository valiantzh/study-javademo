/**
 * 
 * File: Publisher.java <br/>
 * Package: com.study.redis.demo.pubsub <br/>
 * Description:TODO(用一句话描述该文件做什么) <br/>
 * @author zhengxy
 * @Date 2018年10月26日 下午5:00:22
 * @version 1.0
 * 
 */
package com.study.redis.demo.pubsub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/** 
 *   发布者
 * @author zhengxy
 * @date 2018年10月26日 下午5:00:22  
 *   
 */
public class Publisher extends Thread{
    private Logger log = LoggerFactory.getLogger(this.getClass());
    private final JedisPool jedisPool;

    public Publisher(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
    
    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Jedis jedis = jedisPool.getResource();   //连接池中取出一个连接
        while (true) {
            String line = null;
            try {
                line = reader.readLine();
                if (!"quit".equals(line)) {
                    jedis.publish("mychannel", line);   //从 mychannel 的频道上推送消息
                } else {
                    log.info("Publisher quit");
                    break;
                }
                Thread.sleep(20);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
