/**
 * 
 * File: MemCachedClient4Spy.java <br/>
 * Package: com.study.memcached.demo <br/>
 * Description:TODO(用一句话描述该文件做什么) <br/>
 * @author zhengxy
 * @Date 2018年10月27日 下午11:17:30
 * @version 1.0
 * 
 */
package com.study.memcached.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

/**
 * 
 * @author zhengxy
 * @date 2018年10月27日 下午11:17:30
 * 
 */
public class MemCachedClient4Spy {
    private MemcachedClient mcc;
    
    public MemCachedClient4Spy() throws IOException {
        mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
        System.out.println("Connection to server sucessful.");
    }
    
    private void connect() throws IOException {
        
        try {
            // 本地连接 Memcached 服务
            mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server sucessful.");
            
            // 关闭连接
            mcc.shutdown();
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void close() {
        // 关闭连接
        mcc.shutdown();
    }
    
    public void showAddOperate() throws InterruptedException, ExecutionException {
        System.out.println("====================== add ==========================");
        // 添加数据
        Future fo = mcc.set("runoob", 900, "Free Education");
        
        // 打印状态
        System.out.println("set status:" + fo.get());
        
        // 输出
        System.out.println("runoob value in cache - " + mcc.get("runoob"));
        
        // 添加
        fo = mcc.add("runoob", 900, "memcached");
        
        // 打印状态
        System.out.println("add status:" + fo.get());
        
        // 添加新key
        fo = mcc.add("codingground", 900, "All Free Compilers");
        
        // 打印状态
        System.out.println("add status:" + fo.get());
        
        // 输出
        System.out.println("codingground value in cache - " + mcc.get("codingground"));
        
    }
    
    public void showReplaceOperate() throws InterruptedException, ExecutionException {
        System.out.println("====================== replace ==========================");
        // 添加第一个 key=》value 对
        Future fo = mcc.set("runoob", 900, "Free Education");

        // 输出执行 add 方法后的状态
        System.out.println("add status:" + fo.get());

        // 获取键对应的值
        System.out.println("runoob value in cache - " + mcc.get("runoob"));

        // 添加新的 key
        fo = mcc.replace("runoob", 900, "Largest Tutorials' Library");

        // 输出执行 set 方法后的状态
        System.out.println("replace status:" + fo.get());

        // 获取键对应的值
        System.out.println("runoob value in cache - " + mcc.get("runoob"));

    }
    
    public void showAppendOperate() throws InterruptedException, ExecutionException{
        System.out.println("====================== append ==========================");
     // 添加数据
        Future fo = mcc.set("runoob", 900, "Free Education");

        // 输出执行 set 方法后的状态
        System.out.println("set status:" + fo.get());

        // 获取键对应的值
        System.out.println("runoob value in cache - " + mcc.get("runoob"));

        // 对存在的key进行数据添加操作
        //fo = mcc.append("runoob", 900, " for All");

        // 输出执行 set 方法后的状态
        System.out.println("append status:" + fo.get());
        
        // 获取键对应的值
        System.out.println("runoob value in cache - " + mcc.get("codingground"));
    }
    
    public void showPrependOperate() throws InterruptedException, ExecutionException{
        System.out.println("====================== prepend ==========================");
     // 添加数据
        Future fo = mcc.set("runoob", 900, "Free Education");

        // 输出执行 set 方法后的状态
        System.out.println("set status:" + fo.get());

        // 获取键对应的值
        System.out.println("runoob value in cache - " + mcc.get("runoob"));

        // 对存在的key进行数据添加操作
        //fo = mcc.prepend("runoob", 900, "Free ");

        // 输出执行 set 方法后的状态
        System.out.println("append status:" + fo.get());
        
        // 获取键对应的值
        System.out.println("runoob value in cache - " + mcc.get("codingground"));
    }
    
    public void showCASOperate() throws InterruptedException, ExecutionException{
        System.out.println("====================== CAS ==========================");
        // 添加数据
        Future fo = mcc.set("runoob", 900, "Free Education");

        // 输出执行 set 方法后的状态
        System.out.println("set status:" + fo.get());
           
        // 使用 get 方法获取数据
        System.out.println("runoob value in cache - " + mcc.get("runoob"));

        // 通过 gets 方法获取 CAS token（令牌）
        CASValue casValue = mcc.gets("runoob");

        // 输出 CAS token（令牌） 值
        System.out.println("CAS token - " + casValue);

        // 尝试使用cas方法来更新数据
        CASResponse casresp = mcc.cas("runoob", casValue.getCas(), 900, "Largest Tutorials-Library");
        
        // 输出 CAS 响应信息
        System.out.println("CAS Response - " + casresp);

        // 输出值
        System.out.println("runoob value in cache - " + mcc.get("runoob"));
    }
    
}
