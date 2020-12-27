package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class template {

	private int id;
    private String data;
    private String template_name;
    private String language;
    private String subject;
    
	public template() {

	}

	public template(int id, String data, String name, String language, String subject) {
		this.id = id;
		this.data = data;
		this.template_name = name;
		this.language = language;
		this.subject = subject;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTemplate_name() {
		return template_name;
	}

	public void setTemplate_name(String name) {
		this.template_name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
     
	
    
}
