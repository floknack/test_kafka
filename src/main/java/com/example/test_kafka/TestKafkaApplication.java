package com.example.test_kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.test_kafka.consumer.KafkaMessageConsumer;
import com.example.test_kafka.publisher.KafkaMessagePublisher;

@SpringBootApplication
public class TestKafkaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestKafkaApplication.class, args);
		
	}

	@Autowired
	KafkaMessagePublisher kafkaMessagePublisher;
	
	@Autowired
	KafkaMessageConsumer kafkaMessageConsumer;
	
	@Override
	public void run(String... args) throws Exception {
		
		kafkaMessagePublisher.sendMessage("mon message");
		String message = "";
		kafkaMessageConsumer.listenGroupFoo(message);
	}

}
