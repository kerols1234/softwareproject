package com.example.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ArrayOfData;
import com.example.model.EmailQueue;
import com.example.model.template;
import com.example.service.EmailService;
import com.example.service.TemplateService;

@RestController
public class EmailQueueController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private TemplateService tempaletService;
	
	
	@PostMapping("/email/{sender}/{receiver}/{id}")
	public void  queuing(@RequestBody ArrayOfData ex, @PathVariable String sender, @PathVariable String receiver, @PathVariable int id) {
		template t = tempaletService.get(id);
		EmailQueue queue = new EmailQueue();
		queue.setLanguage(t.getLanguage());
		queue.setReceiver(receiver);
		queue.setSender(sender);
		queue.setSubject(t.getSubject());
		String d = t.getData();
		
		boolean b = false;
		String v = "";
		int j = 0;
		for(int i = 0; i < d.length(); i++) {
			if(d.charAt(i) == '{') {
				v = "{";
				b = true;
			}else if(d.charAt(i) == '}'){
				v += d.charAt(i);
				d = d.replace(v, ex.getData().get(j));
				j++;
				b = false;
			}else if(b) {
				v += d.charAt(i); 
			}
		}
		
		queue.setBody(d);
		emailService.save(queue);
 	}
	
	@GetMapping("/email")
	public List<EmailQueue> list(){
		return emailService.listAll();
	}
	
	@GetMapping("/email/{id}")
	public ResponseEntity<EmailQueue> get(@PathVariable Integer id) {
		try {
			EmailQueue t = emailService.get(id);
			return new ResponseEntity<EmailQueue>(t,HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<EmailQueue>(HttpStatus.NOT_FOUND);
		}
	}
}
