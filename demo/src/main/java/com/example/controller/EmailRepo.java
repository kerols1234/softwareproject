package com.example.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Email;

public interface EmailRepo extends JpaRepository<Email, Integer> {

}
