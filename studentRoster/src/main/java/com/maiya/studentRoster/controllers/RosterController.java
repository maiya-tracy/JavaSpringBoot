package com.maiya.studentRoster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.maiya.studentRoster.models.Address;
import com.maiya.studentRoster.models.Student;
import com.maiya.studentRoster.services.RosterService;

@Controller
public class RosterController {
	@Autowired
	RosterService rs;

//	******************
//	show home
//	******************
	@GetMapping("/")
	public String home() {
		return "/WEB-INF/studentRoster/home.jsp";
	}

//	******************
//	show all students
//	******************
	@GetMapping("/students")
	public String index(Model model) {
		List<Student> students = rs.allStudents();
		model.addAttribute("students", students);
		return "/WEB-INF/studentRoster/index.jsp";
	}

//	******************
//	show one student
//	******************
	@GetMapping("/students/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Student student = rs.findStudent(id);
		model.addAttribute("student", student);
		return "/WEB-INF/studentRoster/show.jsp";
	}

//	******************
//	add student
//	******************
	@GetMapping("/student/new")
	public String newStudent(@ModelAttribute("student") Student student) {
		return "/WEB-INF/studentRoster/newstudent.jsp";
	}

	@PostMapping(value = "/students")
	public String create(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "/WEB-INF/studentRoster/newstudent.jsp";
		} else {
			rs.createStudent(student);
			return "redirect:/students";
		}
	}
	
//	******************
//	add contact
//	******************
	@GetMapping("/contact/new")
	public String newAddress(@ModelAttribute("contact") Address address, Model model) {
		List<Student> students = rs.allStudents();
		model.addAttribute("students", students);
		return "/WEB-INF/studentRoster/newaddress.jsp";
	}
	
	@PostMapping(value = "/contacts")
	public String createAddress(@Valid @ModelAttribute("contact") Address address, BindingResult result) {
		if (result.hasErrors()) {
			return "/WEB-INF/studentRoster/newaddress.jsp";
		} else {
			rs.createAddress(address);
			return "redirect:/students";
		}
	}

//	******************
//    edit student
//	******************
	@GetMapping("/students/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Student student = rs.findStudent(id);
		model.addAttribute("student", student);
		return "/WEB-INF/studentRoster/edit.jsp";
	}

	@PutMapping(value = "/students/{id}")
	public String update(@Valid @ModelAttribute("student") Student student, BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "/WEB-INF/studentRoster/edit.jsp";
		} else {
			rs.updateStudent(id, student);
			return "redirect:/students";
		}
	}

//	******************
//    delete student
//	******************
	@DeleteMapping(value = "/students/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		rs.deleteStudent(id);
		return "redirect:/students";
	}
}
