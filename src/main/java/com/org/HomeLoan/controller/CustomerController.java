package com.org.HomeLoan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.HomeLoan.dto.Customer;
import com.org.HomeLoan.dto.Loan;
import com.org.HomeLoan.service.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/{id}")
	public Customer findUserById(@PathVariable int id) {
		return customerService.findCustomerById(id);
	}

	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {

		List<Loan> loans = new ArrayList<>();
		customer.setLoans(loans);
		
		return customerService.addCustomer(customer);
	}
	
	@PostMapping("/saveCustomer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
}
