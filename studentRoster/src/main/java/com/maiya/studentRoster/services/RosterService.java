package com.maiya.studentRoster.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maiya.studentRoster.models.Address;
import com.maiya.studentRoster.models.Student;
import com.maiya.studentRoster.repositories.AddressRepository;
import com.maiya.studentRoster.repositories.StudentRepository;



@Service
public class RosterService {
	@Autowired
    StudentRepository sr;
    
    // returns all the students
    public List<Student> allStudents() {
        return sr.findAll();
    }
    // creates a student
    public Student createStudent(Student b) {
        return sr.save(b);
    }
    // retrieves a student
    public Student findStudent(Long id) {
        Optional<Student> optionalStudent = sr.findById(id);
        if(optionalStudent.isPresent()) { 
            return optionalStudent.get();
        } else {
            return null;
        }
    }
    
	public Student updateStudent(Long id, String first_name, String last_name, Integer age) {
		Student currentStudent = sr.findById(id).get();
		currentStudent.setFirst_name(first_name);
		currentStudent.setLast_name(last_name);
		currentStudent.setAge(age);
		sr.save(currentStudent);
		return currentStudent;
	}
	public Student updateStudent(Long id, Student student) {
		Student currentStudent = sr.findById(id).get();
		currentStudent.setFirst_name(student.getFirst_name());
		currentStudent.setLast_name(student.getLast_name());
		currentStudent.setAge(student.getAge());
		sr.save(currentStudent);
		return currentStudent;
	}
	public void deleteStudent(Long id) {
		sr.deleteById(id);
	}
	
	
	
//	Address
	
	@Autowired
	AddressRepository ar;
	
	// returns all the address'
	public List<Address> allAddresss() {
		return ar.findAll();
	}
	// creates a address
	public Address createAddress(Address b) {
		return ar.save(b);
	}
	// retrieves a address
	public Address findAddress(Long id) {
		Optional<Address> optionalAddress = ar.findById(id);
		if(optionalAddress.isPresent()) { 
			return optionalAddress.get();
		} else {
			return null;
		}
	}
	
	public Address updateAddress(Long id, String address, String city, String state) {
		Address currentAddress = ar.findById(id).get();
		currentAddress.setAddress(address);
		currentAddress.setCity(city);
		currentAddress.setState(state);
		ar.save(currentAddress);
		return currentAddress;
	}
	public Address updateAddress(Long id, Address address) {
		Address currentAddress = ar.findById(id).get();
		currentAddress.setAddress(address.getAddress());
		currentAddress.setCity(address.getCity());
		currentAddress.setState(address.getState());
		ar.save(currentAddress);
		return currentAddress;
	}
	public void deleteAddress(Long id) {
		ar.deleteById(id);
	}
}
