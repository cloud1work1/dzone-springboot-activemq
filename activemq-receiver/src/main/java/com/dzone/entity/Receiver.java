package com.dzone.entity;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class Receiver {

	@JmsListener(destination="my-activemq")
	public void listener(String message) {
		System.out.println("Message Received... "+ message);
	}
}
