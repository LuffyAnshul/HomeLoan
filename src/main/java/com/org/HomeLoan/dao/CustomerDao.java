package com.org.HomeLoan.dao;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.HomeLoan.dto.Customer;
import com.org.HomeLoan.dto.LoanRepayment;
import com.org.HomeLoan.exception.CustomerException;
import com.org.HomeLoan.helper.CSVHelper;
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
	
	public String addCustomer(Customer customer) {
		Optional<Customer> search = Optional.ofNullable(findCustomerById(customer.getCustomerId()));
		
		if(search.isPresent()) {
			throw new CustomerException("Customer already exists!!");
		} else {
			customerRepo.save(customer);
			return "Customer added successfully";
		}
	}
	
	public String saveCustomer(Customer customer) {
		Optional<Customer> search = Optional.ofNullable(findCustomerById(customer.getCustomerId()));
		
		if(search.isPresent()) {
			
			if(customer.getLogin().size() == 1) {
				customerRepo.save(customer);
				return "Customer Updated successfully";				
			}
			
			throw new CustomerException("Customer Not Logged In");
		} else {
			throw new CustomerException("Customer Doesn't exists!!");
		}
	}
	
	public ByteArrayInputStream load(List<LoanRepayment> repayments) {
	    ByteArrayInputStream in = CSVHelper.repaymentToCSV(repayments);
	    return in;
	}

}
