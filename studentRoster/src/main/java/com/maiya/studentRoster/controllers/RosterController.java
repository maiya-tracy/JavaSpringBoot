package com.maiya.studentRoster.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.maiya.studentRoster.models.Course;
import com.maiya.studentRoster.models.Dorm;
import com.maiya.studentRoster.models.Student;
import com.maiya.studentRoster.models.StudentCourse;
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
	@GetMapping("/student/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Student student = rs.findStudent(id);
		model.addAttribute("student", student);
		List<Course> courses = rs.allCourses();
		model.addAttribute("courses", courses);
		return "/WEB-INF/studentRoster/showOneStudent.jsp";
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
	public String update(@Valid @ModelAttribute("student") Student student, BindingResult result,
			@PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "/WEB-INF/studentRoster/edit.jsp";
		} else {
			rs.updateStudent(id, student);
			return "redirect:/students";
		}
	}

//	******************
//	show all dorms
//	******************
	@GetMapping("/dorms")
	public String showDorms(Model model) {
		List<Dorm> dorms = rs.allDorms();
		model.addAttribute("dorms", dorms);
		return "/WEB-INF/studentRoster/showdorms.jsp";
	}

//	******************
//	show one dorm
//	******************
	@GetMapping("/dorms/{id}")
	public String showOneDorm(Model model, @PathVariable("id") Long id) {
		Dorm dorm = rs.findDorm(id);
		model.addAttribute("dorm", dorm);
		List<Student> students = rs.allStudents();
		model.addAttribute("students", students);
		return "/WEB-INF/studentRoster/showOneDorm.jsp";
	}

//	******************
//	add students to one dorm
//	******************

	@PostMapping(value = "/dorms/addStudent")
	public String updateDorm(HttpServletRequest request) {
		Long student_id = Long.parseLong(request.getParameter("stu_id"));
		Student current_student = rs.findStudent(student_id);
		Long dorm_id = Long.parseLong(request.getParameter("dorm_id"));
		Dorm current_dorm = rs.findDorm(dorm_id);
		current_student.setDorm(current_dorm);
		rs.createStudent(current_student);
		return "redirect:/dorms/" + dorm_id;
	}
	
//	******************
//	remove students from one dorm
//	******************

	@PostMapping(value = "/dorms/removeStudent")
	public String updateDormRemove(HttpServletRequest request) {
		Long student_id = Long.parseLong(request.getParameter("stu_id"));
		Student current_student = rs.findStudent(student_id);
		Long dorm_id = Long.parseLong(request.getParameter("dorm_id"));
		current_student.setDorm(null);
		rs.createStudent(current_student);
		return "redirect:/dorms/" + dorm_id;
	}

//	******************
//	add dorm
//	******************
	@GetMapping("/dorm/new")
	public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
		return "/WEB-INF/studentRoster/newdorm.jsp";
	}

	@PostMapping(value = "/dorms")
	public String create(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
		if (result.hasErrors()) {
			return "/WEB-INF/studentRoster/newdorm.jsp";
		} else {
			rs.createDorm(dorm);
			return "redirect:/dorms";
		}
	}
	
	
//	******************
//	add course
//	******************
	@GetMapping("/class/new")
	public String newCourse(@ModelAttribute("course") Course course) {
		return "/WEB-INF/studentRoster/newcourse.jsp";
	}

	@PostMapping(value = "/classes")
	public String create(@Valid @ModelAttribute("course") Course course, BindingResult result) {
		if (result.hasErrors()) {
			return "/WEB-INF/studentRoster/newcourse.jsp";
		} else {
			rs.createCourse(course);
			return "redirect:/students";
		}
	}
	
//	******************
//	show one course
//	******************
	@GetMapping("/classes/{id}")
	public String showOneCourse(Model model, @PathVariable("id") Long id) {
		Course course = rs.findCourse(id);
		model.addAttribute("course", course);
		List<Student> students = rs.allStudents();
		model.addAttribute("students", students);
		return "/WEB-INF/studentRoster/showOneCourse.jsp";
	}

//	******************
//	add students to one course
//	******************

	@PostMapping(value = "/classes/addStudent")
	public String updateCourse(HttpServletRequest request) {
		Long student_id = Long.parseLong(request.getParameter("stu_id"));
		Student current_student = rs.findStudent(student_id);
		Long course_id = Long.parseLong(request.getParameter("course_id"));
		Course current_course = rs.findCourse(course_id);
		StudentCourse new_student_course = new StudentCourse(current_student, current_course);
		rs.addCourseToStudent(new_student_course);
		return "redirect:/student/" + student_id;
	}
	
//	******************
//	remove students from one course
//	******************

	@PostMapping(value = "/classes/removeStudent")
	public String updateCourseRemove(HttpServletRequest request) {
		Long student_id = Long.parseLong(request.getParameter("stu_id"));
		Student current_student = rs.findStudent(student_id);
		Long course_id = Long.parseLong(request.getParameter("course_id"));
		Course current_course = rs.findCourse(course_id);
		rs.removeCourseFromStudent(current_student, current_course);
		return "redirect:/student/" + student_id;
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
