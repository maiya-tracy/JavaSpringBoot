package com.maiya.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
@RestController
public class HellohumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellohumanApplication.class, args);
	}
	@RequestMapping("/")
	public String hello() { 
		return "Hello Human!";
	}
	@RequestMapping("/{name}")
	public String name(@PathVariable("name") String name) {
		return "Hello " + name + "!";
	}
	@RequestMapping("/{name}/{lname}")
	public String fullname(@PathVariable("name") String name, @PathVariable("lname") String lname) {
		return "Hello " + name + " " + lname + "!";
	}

}
