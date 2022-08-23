package com.org.HomeLoan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.HomeLoan.dto.Loan;

public interface LoanRepo extends JpaRepository<Loan, Integer> {

}
