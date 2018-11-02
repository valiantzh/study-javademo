package com.study.basis.thread.demo1;


public class Demo1Test {
    
    public static void main(String[] args) {
        Factory factory = new Factory(200);//该对象只有一个,所以一下代码中只有一个同步锁
        Producer producer = new Producer(factory);
        Customer customer = new Customer(factory);

        producer.produce(80);
        customer.custome(90);
        producer.produce(140);
        customer.custome(180);
        producer.produce(110);
        
    }
}
