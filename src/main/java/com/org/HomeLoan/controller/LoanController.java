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
import com.org.HomeLoan.exception.CustomerException;
import com.org.HomeLoan.exception.LoanException;
import com.org.HomeLoan.service.LoanService;

@RestController
@RequestMapping(value = "/loan")
public class LoanController {
	
	@Autowired
	LoanService loanService;
	
	@Autowired
	CustomerDao customerDao;
	
	@PostMapping("/applyLoan/{id}")
	public String applyLoan(@RequestBody Loan loan, @PathVariable int id) {
		
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
				return "Loan Repayment Schedule Available";
			} else {
				throw new LoanException("Customer Does Not Exist!!");
			}			
		} else {
			throw new LoanException("Customer Not Eligible!");
		}
		
	}
	
	@PostMapping("/repayLoan/{id}")
	public String repayLoan(@PathVariable int id) {
		Customer customerRef = customerDao.findCustomerById(id);
		List<Loan> loan = customerRef.getLoans();
		
		if(customerRef != null && loan.size() > 0) {
			List<LoanRepayment> repayments = loanService.updateLoanRepayment(loan.get(loan.size() - 1));
			if(repayments.stream().anyMatch(c -> c.getStatus() == false) == false) {
				
				loan.get(0).setLoanRepayment(repayments);
				customerRef.setLoans(loan);	
				customerDao.saveCustomer(customerRef);
				
				return "Loan Repayment Complete";
			}
			
			loan.get(0).setLoanRepayment(repayments);
			customerRef.setLoans(loan);
			customerDao.saveCustomer(customerRef);
			
			return "Loan Repayment Updated";
		} else {
			throw new LoanException("Customer Does Not Exist!!");
		}
		
	}

	@PostMapping("/foreCloseLoan/{id}")
	public String foreCloseLoan(@PathVariable int id) {
		Customer customerRef = customerDao.findCustomerById(id);
		List<Loan> loan = customerRef.getLoans();
		
		if(customerRef != null && loan.size() > 0) {
			List<LoanRepayment> repay = loan.get(loan.size() - 1).getLoanRepayment();
			
			if(repay.stream().filter(o -> o.getStatus() == true).count() >= 3) {
				List<LoanRepayment> repayments = loanService.foreCloseLoanRepayment(repay);
					
				loan.get(loan.size() - 1).setLoanRepayment(repayments);
				customerRef.setLoans(loan);	
				customerDao.saveCustomer(customerRef);
				
				return "Complete Fore Payment of Loan Complete";
			}
			
			
			return "Fore Closure of Loan Not Possible Yet; Please Complete 3 months of minimum loan repayment";
		} else {
			throw new LoanException("Customer Does Not Exist!!");
		}
	}
	
	
}
