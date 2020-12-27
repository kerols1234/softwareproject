package com.example.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.EmailQueue;

public interface EmailQueueRepo extends JpaRepository<EmailQueue, Integer> {

}
