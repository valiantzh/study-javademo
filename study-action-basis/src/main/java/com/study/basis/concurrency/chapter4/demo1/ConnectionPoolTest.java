package com.study.basis.concurrency.chapter4.demo1;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author valiantzh
 * @version 1.0
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);

    //保证所有Connection能够同时开始
    static CountDownLatch start = new CountDownLatch(1);
    //main线程等待所有connectionRunner结束以后才能继续执行
    static CountDownLatch end;

    public static void main(String[] args) throws Exception{
        int threadCount = 800;
        end = new CountDownLatch(threadCount);

        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count,got, notGot), "ConnectionRunnerThread");
            thread.start();
        }

        start.countDown();//确保同时开始执行

        end.await();//等待所有线程执行完成

        System.out.println("total invoke: " + threadCount* count);
        System.out.println("got connection: " + got);
        System.out.println("not got connection: " + notGot);
    }

    static class ConnectionRunner implements Runnable{

        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot){
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try{
                start.await();
            } catch (Exception e){}

            while(count>0){
                try{
                    Connection connection = pool.fetchConnection(1000);
                    if(connection != null){
                        try{
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }

                    }else{
                        notGot.incrementAndGet();
                    }
                }catch (Exception ex){

                }finally{
                    count --;
                }
            }
            end.countDown();
        }
    }
}
