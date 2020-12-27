package com.example;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {

	@Autowired
	private TemplateService service;
	
	@GetMapping("/templates")
	public List<template> list(){
		return service.listAll();
	}
	
	@GetMapping("/templates/{id}")
	public ResponseEntity<template> get(@PathVariable Integer id) {
		try {
			template t = service.get(id);
			return new ResponseEntity<template>(t,HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<template>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/templates")
	public void add(@RequestBody template t) {
		service.save(t);
 	}
	
	@PutMapping("/templates/{id}")
	public ResponseEntity<?> update(@RequestBody template t,
			@PathVariable Integer id) {
		try {
			template t1 = service.get(id);
			service.save(t);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/templates/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			template t1 = service.get(id);
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
