package com.org.HomeLoan.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.HomeLoan.repo.DocumentRepo;

@Repository

public class DocumentDao {
	
	@Autowired
	DocumentRepo documentRepo;

}
