package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmailQueue {
	private int id;
	private int idOfTemplate;
	private String sender;
	private String receiver;

	public EmailQueue() {
	}

	public EmailQueue(int id, int idOfTemplate, String sender, String receiver) {
		super();
		this.id = id;
		this.idOfTemplate = idOfTemplate;
		this.sender = sender;
		this.receiver = receiver;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdOfTemplate() {
		return idOfTemplate;
	}

	public void setIdOfTemplate(int idOfTemplate) {
		this.idOfTemplate = idOfTemplate;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

}
