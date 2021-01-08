package com.example.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Sms;

public interface SmsRepo extends JpaRepository<Sms, Integer>{
}
