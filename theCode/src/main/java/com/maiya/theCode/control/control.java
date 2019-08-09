package com.maiya.theCode.control;

import org.springframework.stereotype.Controller;
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
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public String login(@RequestParam(value="thecode") String theSecretCode) {
		if (theSecretCode.equals("bushido")) {
			return "redirect:/success";
		} else {
			return "redirect:/createError";
		}
	}
	@RequestMapping("/success")
	public String successpage() {
		return "success.jsp";
	}
	@RequestMapping("/createError")
	public String flashMessages(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "You must train harder!");
		return "redirect:/";
	}
}
