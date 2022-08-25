package com.org.HomeLoan.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.HomeLoan.dao.CustomerDao;
import com.org.HomeLoan.dto.Customer;
import com.org.HomeLoan.dto.Loan;
import com.org.HomeLoan.dto.LoanRepayment;

@Repository
public class CustomerService {
	
	@Autowired
	CustomerDao dao;
	
	public Customer findCustomerById(int id) {
		return dao.findCustomerById(id);
	}
	
	public String addCustomer (Customer customer) {
		return dao.addCustomer(customer);
	}
	
	public String saveCustomer(Customer customer) {
		return dao.saveCustomer(customer);
	}
	
	public ByteArrayInputStream load(int id) {
		Customer customer = dao.findCustomerById(id);
		
		if(customer != null) {
			List<Loan> loans= customer.getLoans();
			if(loans.size() > 0) {
				List<LoanRepayment> repayments = loans.get(0).getLoanRepayment(); 
				return dao.load(repayments);							
			} 
			return null;
		}
		
		return null;
	}

}