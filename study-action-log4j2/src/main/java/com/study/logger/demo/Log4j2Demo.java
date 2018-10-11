package com.study.logger.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Demo {
    
    private static Logger log = LogManager.getLogger(Log4j2Demo.class);
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
