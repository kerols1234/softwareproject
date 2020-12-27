package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
