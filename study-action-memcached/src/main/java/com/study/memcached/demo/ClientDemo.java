/**
 * 
 * File: ClientDemo.java <br/>
 * Package: com.study.memcached.demo <br/>
 * Description:TODO(用一句话描述该文件做什么) <br/>
 * @author zhengxy
 * @Date 2018年10月27日 下午10:41:16
 * @version 1.0
 * 
 */
package com.study.memcached.demo;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/** 
 *   
 * @author zhengxy
 * @date 2018年10月27日 下午10:41:16  
 *   
 */
public class ClientDemo {
    
    /**  
     * @Title: main  
     * @Description: TODO(这里用一句话描述这个方法的作用)  
     * @param args  
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //new MemCachedClient4Whalin().test();;
        
        try {
            MemCachedClient4Spy client2 = new MemCachedClient4Spy();
            
            client2.showAddOperate();
            client2.showReplaceOperate();
            client2.showPrependOperate();
            client2.showCASOperate();
            
            client2.close();
        } catch (IOException | InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    
}
