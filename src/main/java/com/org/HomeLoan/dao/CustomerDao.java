package com.org.HomeLoan.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.HomeLoan.dto.Customer;
import com.org.HomeLoan.exception.CustomerException;
import com.org.HomeLoan.repo.CustomerRepo;

@Repository
public class CustomerDao {
	
	@Autowired
	CustomerRepo customerRepo;
	
	public Customer findCustomerById(int id) {
		Optional<Customer> customer = customerRepo.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		} else {
			return null;
		}
	}
	
	public Customer addCustomer(Customer customer) {
		Optional<Customer> search = Optional.ofNullable(findCustomerById(customer.getCustomerId()));
		
		if(search.isPresent()) {
			return null;
		} else {
			return customerRepo.save(customer);
		}
	}
	
	public Customer saveCustomer(Customer customer) {
		Optional<Customer> search = Optional.ofNullable(findCustomerById(customer.getCustomerId()));
		
		if(search.isPresent()) {
			return customerRepo.save(customer);
		} else {
			return null;
		}
	}

}
