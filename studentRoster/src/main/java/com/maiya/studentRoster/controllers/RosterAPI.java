package com.maiya.studentRoster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maiya.studentRoster.models.Student;
import com.maiya.studentRoster.services.RosterService;

@RestController
public class RosterAPI {
	@Autowired
    RosterService rs;

	@GetMapping("/api/students")
	public List<Student> index() {
		return rs.allStudents();
	}

	@PostMapping(value = "/api/students")
	public Student create(@RequestParam(value = "first_name") String first_name, @RequestParam(value = "last_name") String last_name, @RequestParam(value = "age") Integer age) {
		Student student = new Student(first_name, last_name, age, null, null);
		return rs.createStudent(student);
	}

	@GetMapping("/api/students/{id}")
	public Student show(@PathVariable("id") Long id) {
		Student student = rs.findStudent(id);
		return student;
	}
	
	@PutMapping(value="/api/students/{id}")
    public Student update(@PathVariable("id") Long id, @RequestParam(value="first_name") String first_name, @RequestParam(value="last_name") String last_name, @RequestParam(value="age") Integer age) {
        Student student = rs.updateStudent(id, first_name, last_name, age);
        return student;
    }
    
    @DeleteMapping(value="/api/students/{id}")
    public void destroy(@PathVariable("id") Long id) {
    	rs.deleteStudent(id);
    }
}
