package com.maiya.studentRoster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maiya.studentRoster.models.StudentCourse;

@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourse, Long> {
	List<StudentCourse> findAll();

}
