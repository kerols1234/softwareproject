package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Sms;
import com.example.repo.SmsRepo;

@Service
public class SmsService {

	@Autowired
	private SmsRepo smsRepo;
	
	public void save(Sms e) {
		smsRepo.save(e);
	}

	public void delete(Integer id) {
		smsRepo.deleteById(id);
	}
	
	public Sms get(Integer id) {
		return smsRepo.findById(id).get();
	}

	public List<Sms> listAll(){
		return smsRepo.findAll();
	}
}
