package com.study.logger.demo;

import org.apache.log4j.Logger;

/**
 * 
 *   
 * @author zhengxy
 * @date 2018年9月29日 上午10:07:44  
 *
 */
public class Log4jDemo {
    private static Logger log = Logger.getLogger(Log4jDemo.class);
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        log.trace("trace log..");
        log.debug("debug log..");
        log.info("info log..");
        log.warn("warn log..");
        log.error("error log..");
        log.fatal("fatal log ..");
    }
    
}
