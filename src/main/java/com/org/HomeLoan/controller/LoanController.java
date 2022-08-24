package com.org.HomeLoan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.HomeLoan.dao.CustomerDao;
import com.org.HomeLoan.dto.Customer;
import com.org.HomeLoan.dto.Loan;
import com.org.HomeLoan.dto.LoanRepayment;
import com.org.HomeLoan.service.LoanService;

@RestController
@RequestMapping(value = "/loan")
public class LoanController {
	
	@Autowired
	LoanService loanService;
	
	@Autowired
	CustomerDao customerDao;
	
	@PostMapping("/applyLoan/{id}")
	public List<Loan> applyLoan(@RequestBody Loan loan, @PathVariable int id) {
		
		boolean isEligible = loanService.isEligible(loan);
		
		if(isEligible) {
			Customer customerRef = customerDao.findCustomerById(id);
			
			if(customerRef != null) {
				
				List<LoanRepayment> repayments = loanService.generateRepayment(loan);
				loan.setLoanRepayment(repayments);
				
				List<Loan> loans= new ArrayList<>(customerRef.getLoans());
				loans.add(loan);
				customerRef.setLoans(loans);
				
				customerDao.saveCustomer(customerRef);
				return loans;
			} else {
				return null;
			}			
		} else {
			return null;
		}
		
	}
	
}
