package com.org.HomeLoan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.HomeLoan.dao.CustomerDao;
import com.org.HomeLoan.dto.Customer;

@Repository
public class CustomerService {
	
	@Autowired
	CustomerDao dao;
	
	public Customer findCustomerById(int id) {
		return dao.findCustomerById(id);
	}
	
	public Customer addCustomer (Customer customer) {
		return dao.addCustomer(customer);
	}
	
	public Customer saveCustomer(Customer customer) {
		return dao.saveCustomer(customer);
	}

}