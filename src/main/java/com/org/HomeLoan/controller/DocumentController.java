package com.org.HomeLoan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.HomeLoan.dao.CustomerDao;
import com.org.HomeLoan.dto.Customer;
import com.org.HomeLoan.dto.Document;
import com.org.HomeLoan.service.DocumentService;

@RestController
@RequestMapping(value = "/document")
public class DocumentController {
	
	@Autowired
	DocumentService documentService;
	
	@Autowired
	CustomerDao customerDao;
	
	@GetMapping("/{id}")
	public List<Document> getDocuments(@PathVariable int id) {
		Customer customerRef = customerDao.findCustomerById(id);
		
		if(customerRef != null) {
			return customerRef.getDocs();			
		} else {
			return null;
		}
	}
	
	@PostMapping("/addDocument/{id}")
	public List<Document> addDocument(@RequestBody Document document, @PathVariable int id) {
		Customer customerRef = customerDao.findCustomerById(id);
		
		if(customerRef != null) {
			List<Document> documents= new ArrayList<>(customerRef.getDocs());
			documents.add(document);
			customerRef.setDocs(documents);
			
			customerDao.saveCustomer(customerRef);
			return documents;			
		} else {
			System.out.println("CANNOT ADD DOCUMENT; CUSTOMER DOESNT EXIST");
			return null;
		}
		
	}
	
}
