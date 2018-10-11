package com.study.logger.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * http://logback.qos.ch
 * 参考官方文档（http://logback.qos.ch/documentation.html）
 *   
 * @author zhengxy
 * @date 2018年9月29日 下午1:07:52  
 *
 */
public class Slf4jLogbackDemo {
    private static Logger log = LoggerFactory.getLogger(Slf4jLogbackDemo.class);
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        log.trace("trace log..");
        log.debug("debug log..");
        log.info("info log..");
        log.warn("warn log..");
        log.error("error log..");
    }
    
}
/*
 * https://www.cnblogs.com/warking/p/5710303.html
 * https://blog.csdn.net/zzzgd_666/article/details/80458444
 */
