package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.EmailQueue;
import com.example.service.EmailService;

@RestController
public class EmailQueueController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/email")
	public void  queuing(@RequestBody EmailQueue e) {
		emailService.save(e);
 	}
	
}
