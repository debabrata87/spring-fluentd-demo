package com.example.spring_fluentd.controller;

import java.util.Random;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fluentd-demo")
public class MyController {
	private static final Logger log = LoggerFactory.getLogger(MyController.class);

	
	//http://localhost:8085/fluentd-demo/test
	@GetMapping("/test")
	public String get() {

		Random r = new Random();

		String statement = "This is a test log from Spring Boot Application : "
				+ Stream.generate(() -> r.nextInt(5000)).limit(1).findFirst().orElse(0); 
		log.info(statement);
		return statement;
	}
}
