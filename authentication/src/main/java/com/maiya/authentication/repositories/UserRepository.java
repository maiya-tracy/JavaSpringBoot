package com.maiya.authentication.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maiya.authentication.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
}
