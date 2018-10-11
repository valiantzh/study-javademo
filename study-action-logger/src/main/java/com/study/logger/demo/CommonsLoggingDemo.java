package com.study.logger.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 *   commons-logging.properties文件中指定日志对象和日志工厂
 * @author zhengxy
 * @date 2018年9月29日 上午8:26:58  
 *
 */
public class CommonsLoggingDemo {
    private static Log log = LogFactory.getLog(CommonsLoggingDemo.class);
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        log.debug("debug log..");
        log.info("info log..");
        log.warn("warn log..");
        log.error("error log..");
        log.fatal("fatal log..");
    }
    
}
