package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsQueueRepo extends JpaRepository<SmsQueue, Integer>{

}
