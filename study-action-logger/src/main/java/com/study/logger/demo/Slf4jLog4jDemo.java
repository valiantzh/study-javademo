package com.study.logger.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jLog4jDemo {
    private static Logger log = LoggerFactory.getLogger(Slf4jLog4jDemo.class);
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        log.trace("trace log..");
        log.debug("debug log..");
        log.info("info log..");
        log.warn("warn log..");
        log.error("error log..");
    }
    
}
