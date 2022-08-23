package com.org.HomeLoan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.HomeLoan.dto.Customer;


public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
