package com.org.HomeLoan.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.HomeLoan.dto.Customer;
import com.org.HomeLoan.repo.CustomerRepo;

@Repository
public class CustomerDao {
	
	@Autowired
	CustomerRepo customerRepo;
	
	public Customer findCustomerById(int id) {
		Optional<Customer> customer = customerRepo.findById(id);
		System.out.println(customer);
		if(customer.isPresent()) {
			System.out.println("CUSTOMER IS PRESENT");
			return customer.get();
		} else {
			System.out.println("CUSTOMER DOESNT EXIST, NEEDS TO BE CREATE ACCOUNT");
			return null;
		}
	}
	
	public Customer addCustomer(Customer customer) {
		Optional<Customer> search = Optional.ofNullable(findCustomerById(customer.getCustomerId()));
		
		if(search.isPresent()) {
			return null;
		} else {
			return saveCustomer(customer);
		}
	}
	
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

}
