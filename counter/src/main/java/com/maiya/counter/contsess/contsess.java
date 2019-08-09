package com.maiya.counter.contsess;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class contsess {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		Integer counter = (Integer) session.getAttribute("count");
		counter++;
		session.setAttribute("count", counter);
		return "index.jsp";
	}
	@RequestMapping("/two")
	public String two(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		Integer counter = (Integer) session.getAttribute("count");
		counter+=2;
		session.setAttribute("count", counter);
		return "index.jsp";
	}
	@RequestMapping("/clear")
	public String clear(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		Integer counter = (Integer) session.getAttribute("count");
		counter=0;
		session.setAttribute("count", counter);
		return "index.jsp";
	}

	@RequestMapping("/counter")
	public String counter(Model model, HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		model.addAttribute("counter", count);
		return "counter.jsp";
	}
}
