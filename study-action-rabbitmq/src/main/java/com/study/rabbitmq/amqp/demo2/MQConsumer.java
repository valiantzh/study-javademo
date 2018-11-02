package com.study.rabbitmq.amqp.demo2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

public class MQConsumer extends EndPoint implements Runnable, Consumer{
	private static Logger log = LoggerFactory.getLogger(MQConsumer.class);
	private long cuntmerId = 0l;
	/**  
	 *   
	 * @param endpointName
	 * @throws IOException  
	 */
	public MQConsumer(String endpointName) throws IOException {
		super(endpointName);
	}
	
	/* (non Javadoc)  
	 * @Title: handleConsumeOk  
	 * @Description: TODO
	 * @param consumerTag  
	 * @see com.rabbitmq.client.Consumer#handleConsumeOk(java.lang.String)  
	 */
	@Override
	public void handleConsumeOk(String consumerTag) {
		// TODO Auto-generated method stub
		
	}

	/* (non Javadoc)  
	 * @Title: handleCancelOk  
	 * @Description: TODO
	 * @param consumerTag  
	 * @see com.rabbitmq.client.Consumer#handleCancelOk(java.lang.String)  
	 */
	@Override
	public void handleCancelOk(String consumerTag) {
		log.info("[Customer"+cuntmerId+"] "+consumerTag +" registered");
	}

	/* (non Javadoc)  
	 * @Title: handleCancel  
	 * @Description: TODO
	 * @param consumerTag
	 * @throws IOException  
	 * @see com.rabbitmq.client.Consumer#handleCancel(java.lang.String)  
	 */
	@Override
	public void handleCancel(String consumerTag) throws IOException {
		log.info("[Customer"+cuntmerId+"] "+consumerTag +" Cancel");
	}

	/* (non Javadoc)  
	 * @Title: handleDelivery  
	 * @Description: TODO
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @throws IOException  
	 * @see com.rabbitmq.client.Consumer#handleDelivery(java.lang.String, com.rabbitmq.client.Envelope, com.rabbitmq.client.AMQP.BasicProperties, byte[])  
	 */
	@Override
	public void handleDelivery(String arg0, Envelope arg1, BasicProperties arg2,
			byte[] arg3) throws IOException {
		Map map = (HashMap)SerializationUtils.deserialize(arg3);
		log.info("[Customer"+cuntmerId+"] Message Received: "+ map.get("message"));
	}

	/* (non Javadoc)  
	 * @Title: handleShutdownSignal  
	 * @Description: TODO
	 * @param consumerTag
	 * @param sig  
	 * @see com.rabbitmq.client.Consumer#handleShutdownSignal(java.lang.String, com.rabbitmq.client.ShutdownSignalException)  
	 */
	@Override
	public void handleShutdownSignal(String consumerTag,
			ShutdownSignalException sig) {
		log.info("[Customer"+cuntmerId+"] "+consumerTag +" ShutdownSignal "+sig.getMessage());
		
	}

	/* (non Javadoc)  
	 * @Title: handleRecoverOk  
	 * @Description: TODO
	 * @param consumerTag  
	 * @see com.rabbitmq.client.Consumer#handleRecoverOk(java.lang.String)  
	 */
	@Override
	public void handleRecoverOk(String consumerTag) {
		// TODO Auto-generated method stub
		log.info("[Customer"+cuntmerId+"] "+consumerTag +" RecoverOk");
	}

	/* (non Javadoc)  
	 * @Title: run  
	 * @Description: TODO  
	 * @see java.lang.Runnable#run()  
	 */
	@Override
	public void run() {
		try {
			cuntmerId = Thread.currentThread().getId();
			log.debug("Customer-"+cuntmerId+" Waiting Received messages!");
            //start consuming messages. Auto acknowledge messages.
            channel.basicConsume(endPointName, true,this);
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
		
	}

}
