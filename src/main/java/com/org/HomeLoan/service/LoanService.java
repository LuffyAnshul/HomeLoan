package com.org.HomeLoan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.HomeLoan.dao.LoanDao;
import com.org.HomeLoan.dto.Loan;
import com.org.HomeLoan.dto.LoanRepayment;
import com.org.HomeLoan.dto.PropertyAndIncome;

@Repository
public class LoanService {

	@Autowired
	LoanDao dao;
	
	public boolean isEligible(Loan loan) {
		
		Integer tenure = loan.getTenure();
		Long loanAmount = loan.getLoanAmount();
		PropertyAndIncome property = loan.getPropertyAndIncome().get(0);
		Long income = property.getIncome();
		
		if(tenure >= 5 && tenure <= 20 && loanAmount <= (50*income)) {
			return true;
		}
		return false;
	}
	
	public List<LoanRepayment> generateRepayment(Loan loan) {
		Integer tenure = loan.getTenure();
		Double outStandingAmount = (double)loan.getLoanAmount();
		
		Double EMI = outStandingAmount * 0.01 * Math.pow(1.01, tenure*12) / (Math.pow(1.01, tenure*12) - 1);
		
		List<LoanRepayment> repayments = new ArrayList<>();
		
		for(int i = 1; i <= tenure * 12; i++) {
			LoanRepayment repay = new LoanRepayment();
			
			Double monthlyInterest = outStandingAmount*0.01;
			Double principal = EMI - monthlyInterest;
			outStandingAmount = outStandingAmount - principal;
			
			repay.setInterest(monthlyInterest);
			repay.setPrincipalAmount(principal);
			repay.setOutstanding(outStandingAmount);
			
			repayments.add(repay);
		}
		
		return repayments;
	}

}