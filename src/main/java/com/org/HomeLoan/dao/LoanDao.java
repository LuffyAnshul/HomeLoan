package com.org.HomeLoan.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.HomeLoan.repo.LoanRepo;

@Repository

public class LoanDao {
	
	@Autowired
	LoanRepo loanRepo;

}
