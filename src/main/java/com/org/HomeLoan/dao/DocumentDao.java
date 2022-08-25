package com.org.HomeLoan.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.HomeLoan.dto.Customer;
import com.org.HomeLoan.dto.Document;
import com.org.HomeLoan.repo.DocumentRepo;

@Repository

public class DocumentDao {
	
	@Autowired
	DocumentRepo documentRepo;
	
	public Document addDocument(Document document) {
		return saveDocument(document);
	}
	
	public Document saveDocument(Document document) {
		return documentRepo.save(document);
	}

}
