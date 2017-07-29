package com.rey;

import java.util.Date;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class ConsumMessage implements MqttCallback{
	
	public static void main(String[] args) throws Exception{
		
		MqttClient client=new MqttClient("tcp://localhost:1883", "sub");

		client.setCallback(new ConsumMessage());
		client.connect();
		client.subscribe("test");		
	}

	@Override
	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub
		System.err.println("Connection lost");
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Message arrived "+new Date());
		System.out.println(new String(message.getPayload()));
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		System.out.println("Delivery completed");
	}

}
