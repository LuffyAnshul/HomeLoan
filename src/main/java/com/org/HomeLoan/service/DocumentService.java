package com.org.HomeLoan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.HomeLoan.dao.DocumentDao;

@Repository
public class DocumentService {
	
	@Autowired
	DocumentDao dao;

}