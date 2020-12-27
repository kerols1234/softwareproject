package com.example.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.SmsQueue;

public interface SmsQueueRepo extends JpaRepository<SmsQueue, Integer>{
}
