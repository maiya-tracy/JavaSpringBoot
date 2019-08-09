package com.maiya.date.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		Date d = new java.util.Date();
		model.addAttribute("time", d);
		return "time.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		Date d = new java.util.Date();
		model.addAttribute("date", d);
		return "date.jsp";
	}
}
