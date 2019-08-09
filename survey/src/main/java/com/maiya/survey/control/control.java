package com.maiya.survey.control;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class control {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value = "/submit", method=RequestMethod.POST)
	public String login(HttpSession session, @RequestParam(value="your_name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment") String comment) {
		if (name != null && location != null && language != null) {
			session.setAttribute("name", name);
			session.setAttribute("location", location);
			session.setAttribute("language", language);
			session.setAttribute("comment", comment);
			return "redirect:/success";
		} else {
			return "redirect:/createError";
		}
	}
	@RequestMapping("/success")
	public String successpage(HttpSession session, Model model) {
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("location", session.getAttribute("location"));
		model.addAttribute("language", session.getAttribute("language"));
		model.addAttribute("comment", session.getAttribute("comment"));
		return "success.jsp";
	}
	@RequestMapping("/createError")
	public String flashMessages(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
	}
}
