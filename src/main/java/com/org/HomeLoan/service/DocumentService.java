package com.org.HomeLoan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.HomeLoan.dao.DocumentDao;
import com.org.HomeLoan.dto.Document;

@Repository
public class DocumentService {
	
	@Autowired
	DocumentDao dao;
	
	public Document addDocument (Document document) {
		return dao.addDocument(document);
	}

}