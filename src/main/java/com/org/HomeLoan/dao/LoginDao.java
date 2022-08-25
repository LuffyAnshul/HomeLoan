package com.org.HomeLoan.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.org.HomeLoan.repo.CustomerRepo;
import com.org.HomeLoan.repo.LoginRepo;

public class LoginDao {
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	LoginRepo loginRepo;
}
