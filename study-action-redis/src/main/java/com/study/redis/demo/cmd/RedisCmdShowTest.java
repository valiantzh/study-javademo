package com.study.redis.demo.cmd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RedisCmdShowTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    RedisCmdShow redisClient;
    @Before
    public void setUp() throws Exception {
        log.info("setUp");
        redisClient = new RedisCmdShow();
    }
    
    @After
    public void tearDown() throws Exception {
        log.info("setDown");
        if(redisClient!=null){
            redisClient.close();
        }
    }
    
    @Test
    public void testShowKeyOperate() {
        //fail("Not yet implemented");
        redisClient.showKeyOperate();
    }
    
    @Test
    public void testShowStringOperate() {
        //fail("Not yet implemented");
        redisClient.showStringOperate();
    }
    
    @Test
    public void testShowListOperate() {
        //fail("Not yet implemented");
        redisClient.showListOperate();
    }
    
    @Test
    public void testShowSetOperate() {
        //fail("Not yet implemented");
        redisClient.showSetOperate();
    }
    
    @Test
    public void testShowSortedSetOperate() {
        redisClient.showSortedSetOperate();
    }
    
    @Test
    public void testShowHashOperate() {
        redisClient.showHashOperate();
    }
    
}
