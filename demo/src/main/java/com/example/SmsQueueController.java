package com.example;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsQueueController {
	
	@Autowired
	private SmsService smsService;
	
	@Autowired
	private TemplateService tempService;
	
	@PostMapping("/sms")
	public ResponseEntity<?>  queuing(@RequestBody SmsQueue s) {
		try {
			template t1 = tempService.get(s.getIdOfTemplate());
			smsService.save(s);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
 	}
	
}
