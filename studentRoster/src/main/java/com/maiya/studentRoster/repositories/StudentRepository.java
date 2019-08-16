package com.maiya.studentRoster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maiya.studentRoster.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
	// this method retrieves all the songs from the database
			List<Student> findAll();
			
}
