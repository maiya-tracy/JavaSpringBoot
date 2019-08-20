package com.maiya.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.maiya.authentication.models.User;
import com.maiya.authentication.services.UserService;

@Controller
public class Users {
	@Autowired
	UserService us;

	@RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "authentication/registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "authentication/loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
    	if (result.hasErrors()) {
    		return "authentication/registrationPage.jsp";
    	}
    		// else, save the user in the database, save the user id in session, and redirect them to the /home route
    	else {
    		us.registerUser(user);
    		session.setAttribute("user_id", user.getId());
    		return "redirect:/home";
    	}
       
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    	boolean isAuthenticated = us.authenticateUser(email, password);
    	// if the user is authenticated, save their user id in session
    	if (isAuthenticated) {
    		User current_user = us.findByEmail(email);
    		session.setAttribute("user_id", current_user.getId());
    		return "redirect:/home";
    	}
        // else, add error messages and return the login page
    	else {
    		model.addAttribute("error", "Invalid Credentials. Please try again.");
    		return "authentication/loginPage.jsp";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	User current_user = us.findUserById((Long) session.getAttribute("user_id"));
    	model.addAttribute("current_user", current_user);
    	return "authentication/homePage.jsp";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
    	session.setAttribute("user_id", null);
        // redirect to login page
    	return "redirect:/login";
    }
}
