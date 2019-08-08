package com.maiya.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
@RestController
public class DojoController {
	@RequestMapping("/{dojo}")
	public String dojo(@PathVariable("dojo") String dojoVar) {
		if (dojoVar.equals("san-jose")) {
			return "SJ dojo is the headquarters";
		} else if (dojoVar.equals("dojo")) {
			return "The dojo is awesome!";
		} else if (dojoVar.equals("burbank-dojo")) {
			return "Burbank Dojo SoCal";
		} else {
			return "Dojo: " + dojoVar;
		}
	}
}
