package com.org.HomeLoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.HomeLoan.dto.PropertyAndIncome;
import com.org.HomeLoan.service.PropertyAndIncomeService;

@RestController
@RequestMapping(value = "/income")
public class PropertyAndIncomeController {

	@Autowired
	PropertyAndIncomeService propertyAndIncomeService;
	
	@GetMapping("/{id}")
	public PropertyAndIncome findUserById(@PathVariable int id) {
		System.out.println("INPUT +> " + id);
		return propertyAndIncomeService.findCustomerIncomeById(id);
	}

	@PostMapping("/addIncome")
	public PropertyAndIncome addCustomer(@RequestBody PropertyAndIncome income) {
		return propertyAndIncomeService.addCustomerIncome(income);
	}
	
	@PostMapping("/updateIncome")
	public PropertyAndIncome saveCustomer(@RequestBody PropertyAndIncome income) {
		return propertyAndIncomeService.updateCustomerIncome(income);
	}
}
