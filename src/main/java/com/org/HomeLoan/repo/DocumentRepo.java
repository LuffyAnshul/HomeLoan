package com.org.HomeLoan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.HomeLoan.dto.Document;


public interface DocumentRepo extends JpaRepository<Document, Integer> {

}
