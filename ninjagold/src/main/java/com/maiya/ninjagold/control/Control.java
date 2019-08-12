package com.maiya.ninjagold.control;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Control {
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		DecimalFormat df2 = new DecimalFormat("#.##");
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		model.addAttribute("gold", df2.format(session.getAttribute("gold")));
		ArrayList<String[]> activitiesarr = (ArrayList<String[]>) session.getAttribute("activities");
		model.addAttribute("activities", activitiesarr);
		return "index.jsp";
	}

	@RequestMapping(value = "/process_money/{location}", method = RequestMethod.POST)
	public String login(HttpSession session, @PathVariable("location") String location) {
		Double earnings = 0.0;
		Date today = new java.util.Date();
		if (location.equals("farm")) {
			earnings = returnRandomNumber(10, 20);
			System.out.println(earnings);
			addToSessionActivities(session, "Earned " + String.valueOf(earnings) + " golds from the farm! " + today,
					"good");
		} else if (location.equals("cave")) {
			earnings = returnRandomNumber(5, 10);
			addToSessionActivities(session, "Earned " + String.valueOf(earnings) + " golds from the cave!" + today,
					"good");
		} else if (location.equals("house")) {
			earnings = returnRandomNumber(2, 5);
			addToSessionActivities(session, "Earned " + String.valueOf(earnings) + " golds from the house!" + today,
					"good");
		} else if (location.equals("casino")) {
			earnings = returnRandomNumber(-50, 50);
			if (earnings >= 0) {
				addToSessionActivities(session, "Won " + String.valueOf(earnings) + " golds from the casino!" + today,
						"good");
			} else {
				addToSessionActivities(session,
						"Entered a casino and lost " + String.valueOf(earnings * -1) + " golds... Ouch!" + today,
						"bad");
			}
		}
		addToTotalGold(session, earnings);

		return "redirect:/";

	}

	@RequestMapping("/clear")
	public String successpage(HttpSession session) {
		session.setAttribute("gold", null);
		session.setAttribute("activities", null);
		return "redirect:/";
	}

	public Double addToTotalGold(HttpSession session, Double amount) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", amount);
			System.out.println("adding to gold - not in session");
			System.out.println(amount);
			System.out.println(session.getAttribute("gold"));
		} else {
			Double new_amount;
			if (session.getAttribute("gold").equals(0)) {
				new_amount = ((Integer) session.getAttribute("gold")).doubleValue() + amount;
			} else {
				new_amount = (Double) session.getAttribute("gold") + amount;
			}			
			session.setAttribute("gold", new_amount);
			System.out.println("adding to gold - in session");
			System.out.println(amount);
			System.out.println(session.getAttribute("gold"));
		}
		return amount;
	}

	public Double returnRandomNumber(int low, int high) {
		Random r = new Random();
		Double new_num = low + (high - low) * r.nextDouble();
		return new_num;
	}

	public void addToSessionActivities(HttpSession session, String message, String goodorbad) {
		if (session.getAttribute("activities") == null) {
			session.setAttribute("activities", new ArrayList<String[]>());
		}
		String[] message_arr = { goodorbad, message };
		ArrayList<String[]> activities_arr = (ArrayList<String[]>) session.getAttribute("activities");
		System.out.println(activities_arr);
		activities_arr.add(message_arr);
		session.setAttribute("activities", activities_arr);

	}
}
