package com.org.HomeLoan.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.HomeLoan.dto.Customer;


public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	Optional<Customer> findByEmail(String email);

}
