package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.EmailQueueRepo;
import com.example.model.EmailQueue;

@Service
public class EmailService {

	@Autowired
	private EmailQueueRepo emailRepo;
	
	public void save(EmailQueue e) {
		emailRepo.save(e);
	}

	public void delete(Integer id) {
		emailRepo.deleteById(id);
	}
}
