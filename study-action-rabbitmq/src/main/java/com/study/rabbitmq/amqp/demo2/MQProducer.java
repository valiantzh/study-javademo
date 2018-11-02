package com.study.rabbitmq.amqp.demo2;

import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

public class MQProducer extends EndPoint{

	/**  
	 *   
	 * @param endpointName
	 * @throws IOException  
	 */
	public MQProducer(String endpointName) throws IOException {
		super(endpointName);
	}

	public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",endPointName, null, SerializationUtils.serialize(object));
    }
}
