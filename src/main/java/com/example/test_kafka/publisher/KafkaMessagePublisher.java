package com.example.test_kafka.publisher;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessagePublisher {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value(value = "${message.topic.name}")
	private String topicName;
	
	public void sendMessage(String message) {
		CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);
		future.whenComplete((result, ex) -> {
			if(ex == null) {
				System.out.println("Sent message=[" + message + 
						"] with offset=[" + result.getRecordMetadata().offset() + "]");
			} else {
				System.out.println("Unable to send message=[" + 
		                 message + "] due to : " + ex.getMessage());
			}
		});
	}
}
