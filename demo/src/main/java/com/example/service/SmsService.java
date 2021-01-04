package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.SmsQueueRepo;
import com.example.model.SmsQueue;

@Service
public class SmsService {

	@Autowired
	private SmsQueueRepo smsRepo;
	
	public void save(SmsQueue e) {
		smsRepo.save(e);
	}

	public void delete(Integer id) {
		smsRepo.deleteById(id);
	}
	
	public SmsQueue get(Integer id) {
		return smsRepo.findById(id).get();
	}

	public List<SmsQueue> listAll(){
		return smsRepo.findAll();
	}
}
