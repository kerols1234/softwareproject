package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Email;
import com.example.repo.EmailRepo;

@Service
public class EmailService {

	@Autowired
	private EmailRepo emailRepo;
	
	public void save(Email e) {
		emailRepo.save(e);
	}

	public void delete(Integer id) {
		emailRepo.deleteById(id);
	}
	
	public Email get(Integer id) {
		return emailRepo.findById(id).get();
	}

	public List<Email> listAll(){
		return emailRepo.findAll();
	}
	
}
