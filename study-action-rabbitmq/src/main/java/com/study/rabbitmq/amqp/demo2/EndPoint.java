package com.study.rabbitmq.amqp.demo2;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public abstract class EndPoint {
	private static Logger log = LoggerFactory.getLogger(EndPoint.class);
	protected Channel channel;
    protected Connection connection;
    protected String endPointName;

    public EndPoint(String endpointName) throws IOException{
        this.endPointName = endpointName;

        //Create a connection factory
        ConnectionFactory factory = new ConnectionFactory();

        //hostname of your rabbitmq server
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("test");
        factory.setPassword("test");
        
        factory.setVirtualHost("test1");
        
        
        //getting a connection
        try{
            connection = factory.newConnection();
        }catch (TimeoutException ex) {
            System.out.println(ex);
            log.error(ex.getMessage());
            connection = null;
        }

        //creating a channel
        channel = connection.createChannel();

        //declaring a queue for this channel. If queue does not exist,
        //it will be created on the server.
        channel.queueDeclare(endpointName, false, false, false, null);
    }


    /**
     * 关闭channel和connection。并非必须，因为隐含是自动调用的。
     * @throws IOException
     */
    public void close() throws IOException{
        try{
            this.channel.close();
        } catch (TimeoutException ex){
            System.out.println("ex" + ex);
        }
        this.connection.close();
    }
}
