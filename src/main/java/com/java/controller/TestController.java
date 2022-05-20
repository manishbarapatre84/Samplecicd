package com.java.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping
	public ResponseEntity<String> getFuncation(){
		return new ResponseEntity<String>("This is the test url",HttpStatus.OK);
	}
	
	public String testFuncation(){
		return "This is the test url";
	}

}
