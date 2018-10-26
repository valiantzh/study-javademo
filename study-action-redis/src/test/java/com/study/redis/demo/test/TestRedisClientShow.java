/**
 * 
 * File: TestRedisClientShow.java <br/>
 * Package: com.study.redis.demo.test <br/>
 * Description:TODO(用一句话描述该文件做什么) <br/>
 * @author zhengxy
 * @Date 2018年10月26日 下午4:13:49
 * @version 1.0
 * 
 */
package com.study.redis.demo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.study.redis.demo.RedisClientShow;

/** 
 *   
 * @author zhengxy
 * @date 2018年10月26日 下午4:13:49  
 *   
 */
public class TestRedisClientShow {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    RedisClientShow redisClient;
    /**  
     * @Title: setUp  
     * @Description: TODO(这里用一句话描述这个方法的作用)  
     * @throws java.lang.Exception  
     */
    @Before
    public void setUp() throws Exception {
        log.info("setUp");
        redisClient = new RedisClientShow();
    }
    
    @After
    public void setDown() throws Exception {
        log.info("setDown");
        if(redisClient!=null){
            redisClient.close();
        }
    }
    /**
     * Test method for {@link com.study.redis.demo.RedisClientShow#show()}.
     */
    @Test
    public void testShow() {
        //fail("Not yet implemented");
        redisClient.show();
    }
    
    /**
     * Test method for {@link com.study.redis.demo.RedisClientShow#showKeyOperate()}.
     */
    @Test
    public void testShowKeyOperate() {
        //fail("Not yet implemented");
        redisClient.showKeyOperate();
    }
    
    /**
     * Test method for {@link com.study.redis.demo.RedisClientShow#showStringOperate()}.
     */
    @Test
    public void testShowStringOperate() {
        //fail("Not yet implemented");
        redisClient.showStringOperate();
    }
    
    /**
     * Test method for {@link com.study.redis.demo.RedisClientShow#showListOperate()}.
     */
    @Test
    public void testShowListOperate() {
        //fail("Not yet implemented");
        redisClient.showListOperate();
    }
    
    /**
     * Test method for {@link com.study.redis.demo.RedisClientShow#showSetOperate()}.
     */
    @Test
    public void testShowSetOperate() {
        //fail("Not yet implemented");
        redisClient.showSetOperate();
    }
    
    /**
     * Test method for {@link com.study.redis.demo.RedisClientShow#showSortedSetOperate()}.
     */
    @Test
    public void testShowSortedSetOperate() {
        //fail("Not yet implemented");
        redisClient.showSortedSetOperate();
    }
    
    /**
     * Test method for {@link com.study.redis.demo.RedisClientShow#showHashOperate()}.
     */
    @Test
    public void testShowHashOperate() {
        //fail("Not yet implemented");
        redisClient.showHashOperate();
    }
    
}
