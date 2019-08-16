package com.maiya.studentRoster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maiya.studentRoster.models.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{
	// this method retrieves all the songs from the database
				List<Address> findAll();

}
