package com.study.rabbitmq.amqp.demo1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang3.StringUtils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MQProducer {
	public final static String QUEUE_NAME = "rabbitmq_test1";
	
	public static void main(String[] args) throws IOException, TimeoutException, KeyManagementException, NoSuchAlgorithmException, URISyntaxException{
		Scanner scan = new Scanner(System.in);
		
		//创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        //设置RabbitMQ相关信息
        factory.setUsername("test");
        factory.setPassword("test");
        factory.setHost("192.168.9.25");
        factory.setVirtualHost("test1");
        factory.setPort(5672);

        //factory.setUri("amqp://userName:password@hostName:portNumber/virtualHost");
        
        //创建一个新的连接
        Connection connection = factory.newConnection();

        //创建一个通道
        Channel channel = connection.createChannel();

        // 声明一个队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //发送消息到队列中
        String message = "";//"Hello RabbitMQ 1";
        
        
        while(scan.hasNextLine()){
        	message = scan.nextLine();
        	if(StringUtils.isNotBlank(message)){
        		if("quit".equalsIgnoreCase(message) || "exit".equalsIgnoreCase(message)){
            		break;
            	}
        		
        		channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
    	        System.out.println("Producer Send +'" + message + "'");
        	}
        }

        //关闭通道和连接
        channel.close();
        connection.close();
	}
}