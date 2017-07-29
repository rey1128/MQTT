package com.rey;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MQPub {
	public static void main(String[] args) throws Exception {
		String msg = "new message from tongyu";
		publish(msg);
	}

	public static void publish(String msg) throws Exception {
		MqttClient client = new MqttClient("tcp://localhost:1883", "pub");
		client.connect();
		MqttMessage message = new MqttMessage();

		message.setPayload(msg.getBytes());
		client.publish("spark", message);
		client.disconnect();

	}

}
