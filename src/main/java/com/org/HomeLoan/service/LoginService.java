package com.org.HomeLoan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.HomeLoan.dto.Customer;
import com.org.HomeLoan.dto.Login;
import com.org.HomeLoan.repo.CustomerRepo;
import com.org.HomeLoan.repo.LoginRepo;

@Repository
public class LoginService {

	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	LoginRepo loginRepo;
	
	public String login(Login loginDetails) {
		
		Optional<Customer> customer = customerRepo.findById(loginDetails.getUserId());
		
		if(customer.isPresent()) {
			
			if(customer.get().getLoans().size() == 1) {
				return "Customer Already Logged IN";
			}
			
			String customerEmail = customer.get().getEmail();
			if(customerEmail.compareTo(loginDetails.getEmail()) == 0) {
				String customerPassword = customer.get().getPassword();
				if(customerPassword.compareTo(loginDetails.getPassword()) == 0) {
					List<Login> logins = new ArrayList<>();
					logins.add(loginDetails);
					
					customer.get().setLogin(logins);
					customerRepo.save(customer.get());
					
					return "Login Successful";
				} 
				return "Incorrect Password";
				
			}
			return "Incorrect Customer Email";
			
		}
		return "Customer Does Not Exist";
	}
	
	public String logout (int id) {
		Optional<Customer> customer = customerRepo.findById(id);
		
		if(customer.isPresent()) {
			
			List<Login> logins = customer.get().getLogin();
			
			if(logins.size() == 1) {
				
				System.out.println("LOGIN IN => " + logins.get(0).getUserId());
				
				loginRepo.deleteById(logins.get(0).getUserId());
				
//				logins.removeAll(logins);
//				customer.get().setLogin(logins);
//				customerRepo.save(customer.get());
//				
				return "Customer Logged Out Successfully";
			}
			
			return "Customer Not Logged In";		
		}
		
		return "Customer Does Not Exist";
	}
	
}
