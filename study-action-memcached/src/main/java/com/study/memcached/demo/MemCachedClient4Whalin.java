/**
 * 
 * File: Client4WhalinDemo.java <br/>
 * Package: com.study.memcached.demo <br/>
 * Description:TODO(用一句话描述该文件做什么) <br/>
 * @author zhengxy
 * @Date 2018年10月27日 下午11:09:12
 * @version 1.0
 * 
 */
package com.study.memcached.demo;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

/** 
 *   
 * 官方提供的基于传统阻塞io由Greg Whalin维护的客户端
 * @author zhengxy
 * @date 2018年10月27日 下午11:09:12  
 *   
 */
public class MemCachedClient4Whalin {
    
    public void test(){
        System.out.println("---------------- com.whalin.MemCached ----------------");
        /*初始化SockIOPool，管理memcached的连接池*/  
        String[] servers = { "127.0.0.1:11211" };  
        SockIOPool pool = SockIOPool.getInstance();  
        pool.setServers(servers);  
        pool.setFailover(true);  
        pool.setInitConn(10);  
        pool.setMinConn(5);  
        pool.setMaxConn(250);  
        pool.setMaintSleep(30);  
        pool.setNagle(false);  
        pool.setSocketTO(3000);  
        pool.setAliveCheck(true);  
        pool.initialize();  
        
        /*建立MemcachedClient实例*/  
        MemCachedClient memCachedClient = new MemCachedClient();  
        for (int i = 0; i < 10; i++) {  
            /*将对象加入到memcached缓存*/  
            boolean success = memCachedClient.set("" + i, "Hello!");  
            /*从memcached缓存中按key值取对象*/  
            String result = (String) memCachedClient.get("" + i);  
            System.out.println(String.format("set( %d ): %s", i, success));  
            System.out.println(String.format("get( %d ): %s", i, result));  
        }  
    }
}


/**
 * memcached client for java
 * 网址：http://www.whalin.com/memcached
 * MAVEN库：https://mvnrepository.com/artifact/com.whalin/Memcached-Java-Client
 * 特点：较早推出的memcached JAVA客户端API，应用广泛，运行比较稳定，使用阻塞IO，不支持CAS操作。
 */
