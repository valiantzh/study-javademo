/**
 * 
 * File: Factory.java <br/>
 * Package: com.study.basis.thread.ch2 <br/>
 * Description:TODO(用一句话描述该文件做什么) <br/>
 * @author zhengxy
 * @Date 2018年10月30日 下午4:09:43
 * @version 1.0
 * 
 */
package com.study.basis.thread.demo1;

/**
 * 
 * @author zhengxy
 * 
 */
public class Factory {
    private int capacity; // 容量
    private int quality;  // 实际数量
    
    public Factory(int capacity) {
        this.capacity = capacity;
        this.quality = 0;
    }
    
    // 生产
    public synchronized void produce(int val) {
        try {
            while (val > 0) {
                while (quality >= capacity) {
                    wait();// 当商品数量大于等于最大容量时，生产者不再生产，进行等待消费
                }
                int inc = (quality + val) > capacity ? capacity - quality : val;
                quality += inc;
                val -= inc;
                System.out.println("生产者" + Thread.currentThread().getName() + "生产了:" + inc + "个产品");
                notifyAll();// 通知等待的消费线程进行消费
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    // 消费
    public synchronized void custome(int val) {
        try {
            while (val > 0) {
                while (quality <= 0) {
                    wait();// 当商品数量小于等于0时，消费者不再消费，进行等待生产
                }
                int dec = (val > quality) ? quality : val;
                quality -= dec;
                val -= dec;
                System.out.println("消费者" + Thread.currentThread().getName() + "消费了:" + dec + "个产品");
                notifyAll();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
