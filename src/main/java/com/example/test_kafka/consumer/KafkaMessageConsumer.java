package com.example.test_kafka.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageConsumer {
	
	@Value(value = "${group.id}")
	private String groupId;
	
	@KafkaListener(topics = "${message.topic.name}", groupId = "${group.id}")
	public void listenGroupFoo(String message) {
		System.out.println("Received Message in group " + groupId + " : " + message);
	}
}
