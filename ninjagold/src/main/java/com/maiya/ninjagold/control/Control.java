package com.maiya.ninjagold.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Control {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		return "index.jsp";
	}

	@RequestMapping(value = "/process_money", method = RequestMethod.POST)
	public String login(HttpSession session, @RequestParam(value = "location") String location) {
		double earnings = 0;
		Date today = new java.util.Date();
		if (location == "farm") {
			earnings = returnRandomNumber(10, 20);
			addToSessionActivities(session, "Earned " + String.valueOf(earnings) + " golds from the farm! " + today,
					"good");
		} else if (location == "cave") {
			earnings = returnRandomNumber(5, 10);
			addToSessionActivities(session, "Earned " + String.valueOf(earnings) + " golds from the cave!" + today,
					"good");
		} else if (location == "house") {
			earnings = returnRandomNumber(2, 5);
			addToSessionActivities(session, "Earned " + String.valueOf(earnings) + " golds from the house!" + today,
					"good");
		} else if (location == "casino") {
			earnings = returnRandomNumber(-50, 50);
			if (earnings >= 0) {
				addToSessionActivities(session, "Won " + String.valueOf(earnings) + " golds from the casino!" + today,
						"good");
			} else {
				addToSessionActivities(session,
						"Entered a casino and lost " + String.valueOf(earnings * -1) + " golds... Ouch!" + today,
						"bad");
				addToTotalGold(session, earnings);
			}
		}
		return "redirect:/success";

	}

	@RequestMapping("/clear")
	public String successpage(HttpSession session) {
		session.setAttribute("gold", null);
		session.setAttribute("activities", null);
		return "redirect:/";
	}

	public double addToTotalGold(HttpSession session, double amount) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", amount);
		} else {
			double new_amount = (double) session.getAttribute("gold") + amount;
			session.setAttribute("gold", new_amount);
		}
		return amount;
	}

	public double returnRandomNumber(int low, int high) {
		Random r = new Random();
		double new_num = low + (double) r.nextInt(high - low);
		return new_num;
	}

	public void addToSessionActivities(HttpSession session, String message, String goodorbad) {
		if (session.getAttribute("activities") == null) {
			session.setAttribute("activities", new ArrayList<String[]>);
		}
		String[] message_arr = {goodorbad, message};
	    session.setAttribute("activities", session.getAttribute("activities").add(message_arr));

	}
}
