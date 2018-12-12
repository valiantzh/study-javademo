package com.study.mqtt.demo.paho;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttClisntPubDemo {
    public static final String HOST = "tcp://127.0.0.1:1883";
    public static final String TOPIC = "test-topic";
    private static final String clientid = "server";

    private MqttClient client;
    private MqttTopic topic;
    private MqttTopic topic125;
    private String userName = "admin";
    private String passWord = "password";

    private MqttMessage message;

    public MqttClisntPubDemo() throws MqttException {
        // MemoryPersistence设置clientid的保存形式，默认为以内存保存
        client = new MqttClient(HOST, clientid, new MemoryPersistence());
        connect();
    }

    private void connect() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(false);
        options.setUserName(userName);
        options.setPassword(passWord.toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(10);
        // 设置会话心跳时间
        options.setKeepAliveInterval(20);
        try {
            client.setCallback(new PushCallback());
            client.connect(options);
            topic = client.getTopic(TOPIC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void publish(MqttTopic topic , MqttMessage message) throws MqttPersistenceException,
            MqttException {
        MqttDeliveryToken token = topic.publish(message);
        token.waitForCompletion();
        System.out.println("message is published completely! "
                + token.isComplete());
    }

    public static void main(String[] args) throws MqttException {
        MqttClisntPubDemo server = new MqttClisntPubDemo();
        server.message = new MqttMessage();
        server.message.setQos(2);
        server.message.setRetained(true);
        server.message.setPayload("可以了abc1".getBytes());
        server.publish(server.topic , server.message);

        System.out.println(server.message.isRetained() + "------ratained状态");
    }

}
