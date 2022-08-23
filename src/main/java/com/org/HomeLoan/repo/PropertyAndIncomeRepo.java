package com.org.HomeLoan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.HomeLoan.dto.PropertyAndIncome;

public interface PropertyAndIncomeRepo extends JpaRepository<PropertyAndIncome, Integer> {

}
