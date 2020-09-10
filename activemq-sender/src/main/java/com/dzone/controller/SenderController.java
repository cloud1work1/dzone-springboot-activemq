package com.dzone.controller;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenderController {

	@Autowired
	private Queue queue;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@GetMapping("/message/{message}")
	public ResponseEntity<String> send(@PathVariable("message") String message){
		jmsTemplate.convertAndSend(queue, message);
		return new ResponseEntity(message, HttpStatus.OK);
	}
}
