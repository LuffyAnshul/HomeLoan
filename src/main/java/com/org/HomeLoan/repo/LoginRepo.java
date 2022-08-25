package com.org.HomeLoan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.HomeLoan.dto.Login;

public interface LoginRepo extends JpaRepository<Login, Integer> {
	
}
