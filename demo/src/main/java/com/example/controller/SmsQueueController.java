package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.SmsQueue;
import com.example.service.SmsService;

@RestController
public class SmsQueueController {
	
	@Autowired
	private SmsService smsService;
	
	@PostMapping("/sms")
	public void  queuing(@RequestBody SmsQueue s) {
		smsService.save(s);
 	}
	
}
