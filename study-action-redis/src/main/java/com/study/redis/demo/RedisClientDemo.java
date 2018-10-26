/**
 * 
 * File: RedisClientDemo.java <br/>
 * Package: com.study.redis.client.demo <br/>
 * Description:TODO(用一句话描述该文件做什么) <br/>
 * @author zhengxy
 * @Date 2018年10月25日 上午11:02:34
 * @version 1.0
 * 
 */
package com.study.redis.demo;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

/** 
 *   
 * @author zhengxy
 * @date 2018年10月25日 上午11:02:34  
 *   
 */
public class RedisClientDemo {
    private static Logger log = LoggerFactory.getLogger(RedisClientDemo.class);
    private static Jedis jedis;
    
    public static void connect(){
        jedis = new Jedis("127.0.0.1",10001);
        log.info("连接成功");
    }
    @Test
    public static void stringTest(){
        String key = "strdemokey";
        //设置 redis 字符串数据
        jedis.set(key, "www.study.com");
        // 获取存储的数据并输出
        log.info("redis 存储的字符串为: "+ jedis.get(key));
    }
    public static void listTest(){
        String key = "listdemokey";
        //存储数据到列表中
        jedis.lpush(key, "Runoob");
        jedis.lpush(key, "Google");
        jedis.lpush(key, "Taobao");
        // 获取存储的数据并输出
        java.util.List<String> list = jedis.lrange(key, 0 ,2);
        for(int i=0; i<list.size(); i++) {
            log.info("列表项为: "+list.get(i));
        }
    }
    public static void getKeys(){
        // 获取数据并输出
        Set<String> keys = jedis.keys("*"); 
        Iterator<String> it=keys.iterator() ;   
        while(it.hasNext()){   
            String key = it.next();   
            log.info(key);   
        }
    }
    /**  
     * @Title: main  
     * @Description: TODO(这里用一句话描述这个方法的作用)  
     * @param args  
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        connect();
        stringTest();
        listTest();
        getKeys();
    }
    
}
