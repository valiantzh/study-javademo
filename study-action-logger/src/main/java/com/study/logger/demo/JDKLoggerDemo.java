/**
 * 
 * File: JDKLoggerDemo.java <br/>
 * Package: com.study.logger.demo <br/>
 * Description:TODO(用一句话描述该文件做什么) <br/>
 * @author zhengxy
 * @Date 2018年9月29日 上午8:14:39
 * @version 1.0
 * 
 */
package com.study.logger.demo;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/** 
 *   JDK Logger JDK 1.4开始自带的日志系统
 * @author zhengxy
 * @date 2018年9月29日 上午8:14:39  
 *   
 */
public class JDKLoggerDemo {
    public static Logger log = Logger.getLogger(JDKLoggerDemo.class.toString());

    static{
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.SEVERE);
        log.addHandler(consoleHandler);
    }
    public static void main(String[] args) {
        // 级别：all->finest->finer->fine->config->info->warning->severe->off
        // 级别依次升高，级别越高，打印的日志越少
        log.setLevel(Level.INFO);
        
        log.finest("finest log ..");
        log.finer("finer log ..");
        log.fine("fine log..");
        log.config("config log..");
        log.info("info log..");
        log.warning("warning log..");
        log.severe("severe log..");
        
    }
    
}
