package com.example;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailQueueController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private TemplateService tempService;
	
	@PostMapping("/email")
	public ResponseEntity<?>  queuing(@RequestBody EmailQueue e) {
		try {
			template t1 = tempService.get(e.getIdOfTemplate());
			emailService.save(e);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
 	}
	
}
