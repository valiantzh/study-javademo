package com.study.rabbitmq.amqp.demo2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MQDemo2Main {
	private static Logger log = LoggerFactory.getLogger(MQDemo2Main.class);
	public final static String QUEUE_NAME = "rabbitmq_test1";
	public static void main(String[] args) throws IOException {
		//MQConsumer consumer = new MQConsumer(QUEUE_NAME);
		//Thread consumerThread = new Thread(consumer);
        //consumerThread.start();
		new Thread(new MQConsumer(QUEUE_NAME)).start();
		new Thread(new MQConsumer(QUEUE_NAME)).start();
		
		Scanner scan = new Scanner(System.in);
		//发送消息到队列中
        String msg = "";//"Hello RabbitMQ 1";
        
        
        System.out.print("Producer Send message:" );
        MQProducer producer = new MQProducer(QUEUE_NAME);
        while(scan.hasNextLine()){
        	msg = scan.nextLine();
        	if(StringUtils.isNotBlank(msg)){
        		if("quit".equalsIgnoreCase(msg) || "exit".equalsIgnoreCase(msg)){
            		break;
            	}
        		
        		HashMap message = new HashMap();
                message.put("message", msg);
                producer.sendMessage(message);
                log.info("Producer Send message:"+msg );
        	}
        	
        }
        
        scan.close();
        
        System.out.println("##############end...");
	}

}
