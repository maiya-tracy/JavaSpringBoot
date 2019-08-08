package com.maiya.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
@RestController
@RequestMapping("coding")
public class CodingController {
	@RequestMapping("")
	public String hello() { 
		return "Hello coding dojo";
	}
	@RequestMapping("/python")
	public String python() { 
		return "Python rules";
	}
	@RequestMapping("/java")
	public String java() { 
		return "Java is better";
	}
}




