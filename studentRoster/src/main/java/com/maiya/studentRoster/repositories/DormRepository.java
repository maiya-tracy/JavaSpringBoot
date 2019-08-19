package com.maiya.studentRoster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maiya.studentRoster.models.Dorm;

@Repository
public interface DormRepository extends CrudRepository<Dorm, Long>{
	List<Dorm> findAll();
}
