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
import com.example.model.SmsQueue;
import com.example.model.template;
import com.example.service.SmsService;
import com.example.service.TemplateService;

@RestController
public class SmsQueueController {
	
	@Autowired
	private SmsService smsService;
	
	@Autowired
	private TemplateService tempaletService;
	
	@PostMapping("/sms/{sender}/{receiver}/{id}")
	public void  queuing(@RequestBody ArrayOfData ex, @PathVariable String sender, @PathVariable String receiver, @PathVariable int id) {
		template t = tempaletService.get(id);
		SmsQueue queue = new SmsQueue();
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
		smsService.save(queue);
 	}
	
	@GetMapping("/sms")
	public List<SmsQueue> list(){
		return smsService.listAll();
	}
	
	@GetMapping("/sms/{id}")
	public ResponseEntity<SmsQueue> get(@PathVariable Integer id) {
		try {
			SmsQueue t = smsService.get(id);
			return new ResponseEntity<SmsQueue>(t,HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<SmsQueue>(HttpStatus.NOT_FOUND);
		}
	}
	
}
