package com.example.service;

import java.util.List;

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
	
	public EmailQueue get(Integer id) {
		return emailRepo.findById(id).get();
	}

	public List<EmailQueue> listAll(){
		return emailRepo.findAll();
	}
	
}
